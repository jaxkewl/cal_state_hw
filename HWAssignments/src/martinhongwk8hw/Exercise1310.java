package martinhongwk8hw;

//File: Exercise1310.java
//Author: Nova
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise1310 extends JFrame {

	private JPanel panel;
	private JComboBox combo;

	String names[] = { "RED", "GREEN", "YELLOW", "PURPLE", "ORANGE" };

	public Exercise1310() {
		super("ColorSelect");
		Container container = getContentPane();

		// Make a box with CheckBoxes "background" and "foreground"
		Box buttons1 = Box.createHorizontalBox();
		buttons1.add(Box.createHorizontalGlue());
		buttons1.add(new JCheckBox("background"));
		buttons1.add(new JCheckBox("foreground"));
		buttons1.add(Box.createHorizontalGlue());

		// Make a box with buttons "Ok" and "Cancel"
		Box buttons2 = Box.createHorizontalBox();
		buttons2.add(Box.createHorizontalGlue());
		buttons2.add(new JButton("Ok"));
		buttons2.add(Box.createHorizontalStrut(5));
		buttons2.add(new JButton("Cancel"));
		buttons2.add(Box.createHorizontalGlue());

		// Put the checkboxes and two buttons together
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		panel.add(buttons1);
		panel.add(buttons2);

		// Make the combo box
		combo = new JComboBox(names);

		// Layout the container with BorderLayout
		container.add(combo, BorderLayout.NORTH);
		container.add(panel, BorderLayout.CENTER);

		setSize(300, 135);
		setVisible(true);
	}

	public static void main(String args[]) {
		Exercise1310 application = new Exercise1310();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
