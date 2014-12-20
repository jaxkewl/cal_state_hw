import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MartinHongWk10HW extends JPanel {

	private Random rand = new Random();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		int[] x = { 30, 45, 60 };
		int[] y = { 50, 10, 50 };

		// now draw some triangles
		for (int j = 0; j < 10; j++) {
			GeneralPath triangle = new GeneralPath();

			// create a new random triangle
			for (int i = 0; i < x.length; i++) {
				int newSize = rand.nextInt(20);
				x[i] += newSize + 50;
			}

			// set initial point
			triangle.moveTo(x[0], y[0]);

			// create the rest of the triangle
			for (int i = 1; i < x.length; i++) {
				triangle.lineTo(x[i], y[i]);
			}

			int red = rand.nextInt(256);
			int green = rand.nextInt(256);
			int blue = rand.nextInt(256);

			g2d.setColor(new Color(red, green, blue));
			g2d.fill(triangle);

		}
	}

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		jFrame.add(new MartinHongWk10HW());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(900, 300);
		jFrame.setVisible(true);

	}

}
