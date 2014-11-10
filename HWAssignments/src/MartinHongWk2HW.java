import java.awt.Graphics;
import java.util.zip.GZIPOutputStream;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class MartinHongWk2HW extends JApplet {
	double radiusNum = 5.0;
	String Pi = "\u03a0";  //unicode

	public void init() {

		// ask user for radius and save it as a class field
		String radiusString = JOptionPane.showInputDialog("Enter radius");

		// try converting to a double.
		try {
			radiusNum = Double.parseDouble(radiusString);
		} catch (NumberFormatException exc) {

		}

	}

	public void paint(Graphics g) {

		super.paint(g);
		g.create(0, 0, 100000, 100000);

		// g.drawString("Welcome to Java!", 0, 15);

		int xLoc = 0;
		int yLoc = 20;
		g.drawString("Centering at " + xLoc + " " + yLoc + " with radius= "
				+ (int) radiusNum, 0, 20);

		double circleRadius = 2.0 * radiusNum;
		double circleCircumference = 2 * Math.PI * radiusNum;
		double circleArea = Math.PI * radiusNum * radiusNum;

		int offSet = 15;

		g.drawString("radius 2r=" + (int) circleRadius, xLoc, yLoc + offSet);
		g.drawString("circumference 2 * Pi * r=" + (int) circleCircumference,
				xLoc, yLoc + 2 * offSet);
		g.drawString("area Pi* r^2=" + (int) circleArea, xLoc, yLoc + 3
				* offSet);

		// g.drawOval(xLoc, yLoc, (int) radiusNum, (int) radiusNum);
	}

	// just test code
	public void stop() {
		// System.out.println("Stopping applet");

	}

	public void destory() {
		// System.out.println("Destroying!");
	}

}
