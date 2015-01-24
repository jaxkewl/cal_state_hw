import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MartinHongJava2HW1 implements Runnable {

	// Do Exercise 26.8 in "Java, How to program, Ninth Edition".

	// Write a program that bounces a blue ball inside a JPanel.
	// The ball should begin moving with a mousePressed event.
	// When the ball hits the edge of the JPanel, it should bounce off
	// the edge and continue in the opposite direction.
	// The ball should be updated using a Runnable
	public static void main(String[] args) {
		MartinHongJava2HW1 hw1 = new MartinHongJava2HW1();
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		threadExecutor.execute(hw1);
	}

	private void setupFrame() {
		BlueBall blueBall = new BlueBall();
		JFrame myFrame = new JFrame("Click mouse to start ball");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.add(blueBall);
		myFrame.setSize(700, 700);
		myFrame.setVisible(true);
	}

	@Override
	public void run() {
		setupFrame();
	}

}

@SuppressWarnings("serial")
class BlueBall extends JPanel {

	// current position of the ball center
	private int x = 50; // init value
	private int y = 50; // init value

	private int ballSize = 100;
	private Color ballColor = Color.BLUE;
	private boolean motionStarted = false;
	private int timerDelay = 20; // ms
	private Dimension winSize = getSize();

	private int ballSpeed = 2;
	private int xMotion = 1;
	private int yMotion = 1;

	private Color bgColor = Color.WHITE;

	private Timer swingTimer = null;

	public BlueBall() {

		setBackground(bgColor);

		MouseAdapter mAdapter = new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// x += 20;
				// y += 20;
				// repaint();
				winSize = getSize();
				// super.mousePressed(e);

				Timer swingTimer = new Timer(timerDelay, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// process the ball motion
						determineBallPosition();
						repaint();
					}
				});

				// depending on the state of the motionStarted boolean
				if (motionStarted) { // ball is moving, need to stop it.
					motionStarted = false;
					swingTimer.stop();

				} else { // ball is not moving, need to start it
					motionStarted = true;
					swingTimer.start();
				}

			}

		};
		addMouseListener(mAdapter);

	}

	private void determineBallPosition() {
		// give the current values of x and y, determine what the next values
		// should be
		if (x + ballSize > winSize.getWidth()) {
			xMotion = -1;
		} else if (y + ballSize > winSize.getHeight()) {
			yMotion = -1;
		} else if (x < 0) {
			xMotion = 1;
		} else if (y < 0) {
			yMotion = 1;
		}

		// dont change direction until we get to a boundary.
		x += xMotion * ballSpeed;
		y += yMotion * ballSpeed;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(ballColor);
		g.fillOval(x, y, ballSize, ballSize);

		g.drawString("x: " + Integer.toString(x) + " y: " + Integer.toString(y), 100,
				winSize.height - 20);
	}

}
