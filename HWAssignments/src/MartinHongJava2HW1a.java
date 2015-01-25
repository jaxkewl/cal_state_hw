import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MartinHongJava2HW1a extends JPanel implements Runnable {
	private boolean mouseClicked = false;
	private int x = 50;
	private int y = 300;
	private int xIncrementor = 10;
	private int yIncrementor = 10;

	// resources
	private Color ballColor = Color.BLUE;
	private int ballDiam = 100;

	public MartinHongJava2HW1a() {
		waitForClick();
	}

	private void determineXIncrementor() {
		int radius = ballDiam;

		// check x bounds
		if (x + radius > getWidth() || (x < 0)) {
			xIncrementor *= -1;
		}
	}

	private void determineYIncrementor() {
		int radius = ballDiam;

		// check x bounds
		if (y + radius > getHeight() || (y < 0)) {
			yIncrementor *= -1;
		}
	}

	private void updateXYPosition() {
		while (true) {

			if (mouseClicked) {
				determineXIncrementor();
				determineYIncrementor();

				x += xIncrementor;
				y += yIncrementor;
				repaint();
			}
			else {
				repaint();
			}
			// sleep for a little while so we can see the change
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void waitForClick() {

		MouseAdapter mAdapter = new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (mouseClicked)
					mouseClicked = false;
				else
					mouseClicked = true;
			}
		};
		addMouseListener(mAdapter);
	}

	@Override
	public void run() {
		updateXYPosition();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(ballColor);
		g.fillOval(x, y, ballDiam, ballDiam);
		String stats = "x: " + x + "  y: " + y;
		if (mouseClicked)
			stats += " active: true";
		else
			stats += " active: false";
		g.drawString(stats, 10, getHeight() - 10);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = 500;
		int width = 500;
		JFrame frame = new JFrame();
		MartinHongJava2HW1a hw = new MartinHongJava2HW1a();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(hw);
		frame.setSize(width, height);
		frame.setVisible(true);

		// let the Executor package handle the threads
		ExecutorService thread = Executors.newCachedThreadPool();
		thread.execute(hw);

	}

}
