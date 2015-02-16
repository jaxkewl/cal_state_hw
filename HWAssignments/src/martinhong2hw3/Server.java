package martinhong2hw3;

//Fig. 24.5: Server.java
// Set up a Server that will receive a connection from a client, send 
// a string to the client, and close the connection.
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {

	// this holds all the clients the server knows about
	ArrayList<MyClient> myClients = new ArrayList<>();

	// GUI stuff
	private JTextField enterField; // inputs message from user
	private JTextArea displayArea; // display information to user

	// socket stuff
	private ServerSocket server; // server socket
	private Socket connection; // connection to client

	private int counter = 1; // counter of number of connections

	private int portNum = 12345;

	// set up GUI
	public Server() {
		super("This Server");

		enterField = new JTextField(); // create enterField
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {
			// send message to client
			public void actionPerformed(ActionEvent event) {
				sendData(event.getActionCommand());
				enterField.setText("");
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		add(enterField, BorderLayout.NORTH);

		displayArea = new JTextArea(); // create displayArea
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(600, 300); // set size of window
		setVisible(true); // show window
	} // end Server constructor

	// set up and run server
	public void runServer() {
		try // set up server to receive connections; process connections
		{
			// enable enterField so server user can send messages
			setTextFieldEditable(true);

			while (true) {
				// wait for multiple connections
				// this server is just listening for clients and spinning off
				// new threads
				// to handle them
				server = new ServerSocket(portNum, 100); // create
															// ServerSocket
				try {
					waitForConnection(); // wait for a connection
					// getStreams(); // get input & output streams
					// processConnection(); // process connection
					portNum++;
				} // end try
				catch (EOFException eofException) {
					displayMessage("\nServer terminated connection");
					closeConnection();
				} // end catch
			} // end while

		} // end try
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // end catch
	} // end method runServer

	// close streams and socket
	private void closeConnection() {
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false); // disable enterField

		for (MyClient myClient : myClients) {
			myClient.closeConnection();
		}
	} // end method closeConnection

	// wait for connection to arrive, then display connection info
	private void waitForConnection() throws IOException {
		displayMessage("Waiting for connection on port " + portNum + "\n");
		connection = server.accept(); // allow server to accept connection

		// create an object of the multi threaded class
		ExecutorService thread = Executors.newCachedThreadPool();
		MyClient myClient = new MyClient(connection, displayArea);
		myClients.add(myClient);
		thread.execute(myClient);

		displayMessage("Connection " + counter + " received from: "
				+ connection.getInetAddress().getHostName() + "\n");
	} // end method waitForConnection

	// manipulates displayArea in the event-dispatch thread
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() // updates displayArea
			{
				displayArea.append(messageToDisplay); // append message
			} // end method run
		} // end anonymous inner class
				); // end call to SwingUtilities.invokeLater
	} // end method displayMessage

	// the server has written something and must be communicated out to the
	// connected clients.
	private void sendData(String message) {
		for (MyClient myClient : myClients) {
			myClient.sendData(message + "\n");
		}
	}

	// manipulates enterField in the event-dispatch thread
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() // sets enterField's editability
			{
				enterField.setEditable(editable);
			} // end method run
		} // end inner class
				); // end call to SwingUtilities.invokeLater
	} // end method setTextFieldEditable

	public static void main(String args[]) {
		Server application = new Server(); // create server
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer(); // run server application
	} // end main

	class MyClient implements Runnable {

		private ObjectOutputStream output; // output stream to client
		private ObjectInputStream input; // input stream from client
		private Socket socket;
		private JTextArea displayArea;

		public MyClient(Socket socket, JTextArea displayArea) {
			this.socket = socket;
			this.displayArea = displayArea;
		}

		@Override
		public void run() {

			try {
				input = new ObjectInputStream(socket.getInputStream());
				output = new ObjectOutputStream(socket.getOutputStream());
				sendData("hello from the server " + socket.getLocalPort()
						+ "\n");

				// now we listen for inputs
				listenForInputs();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		private void listenForInputs() {

			while (true) {
				// listen for inputs from the client here
				try {

					// wait for an input
					displayMessage((String) input.readObject() + "\n");

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SocketException e) {
					displayMessage("client on " + socket.getLocalPort()
							+ " disconnected");
					closeConnection();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		private void sendData(String message) {
			try // send object to client
			{
				output.writeObject("SERVER>>> " + message + "\n");
				output.flush(); // flush output to client
				displayMessage("\nSERVER>>> " + message);
			} // end try
			catch (IOException ioException) {
				displayArea.append("\nError writing object");
			} // end catch
		} // end method sendData

		// get streams to send and receive data
		private void getStreams() throws IOException {
			// set up output stream for objects
			output = new ObjectOutputStream(connection.getOutputStream());
			output.flush(); // flush output buffer to send header information

			// set up input stream for objects
			input = new ObjectInputStream(connection.getInputStream());

			displayMessage("\nGot I/O streams\n");
		} // end method getStreams

		// process connection with client
		private void processConnection() throws IOException {
			String message = "Connection successful";
			sendData(message); // send connection successful message

			do // process messages sent from client
			{
				try // read message and display it
				{
					message = (String) input.readObject(); // read new message
					displayMessage("\n" + message); // display message
				} // end try
				catch (ClassNotFoundException classNotFoundException) {
					displayMessage("\nUnknown object type received");
				} // end catch

			} while (!message.equals("CLIENT>>> TERMINATE"));
		} // end method processConnection

		// close streams and socket
		private void closeConnection() {
			displayMessage("\nTerminating connection\n");
			setTextFieldEditable(false); // disable enterField

			try {
				output.close(); // close output stream
				input.close(); // close input stream
				connection.close(); // close socket
			} // end try
			catch (IOException ioException) {
				ioException.printStackTrace();
			} // end catch
		} // end method closeConnection

	}

} // end class Server

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
