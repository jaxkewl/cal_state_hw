package MartinHongWk5HW;

import java.security.acl.Permission;

public class Rectangle {

	private float length = 1.0f;
	private float width = 1.0f;

	private float perimiter = 0.0f;
	private float area = 0.0f;

	private boolean validInput(float input) {

		// verify input
		if ((input < 0) || (input > 20)) {
			System.out.println("You entered " + input
					+ " Enter float between 0 and 20.");
			return false;
		}
		return true;
	}

	public void performCalculations() {
		perimiter = 2 * length + 2 * width;
		area = length * width;
	}

	
	public void displayCalculations(){
		
		System.out.println("Length = " + length);
		System.out.println("Width = " + width);
		System.out.println("Area = Length * Width = " + area);
		System.out.println("Perimiter = 2*Width + 2*Length = " + perimiter);
		
	}
	
	public float getLength() {
		return length;
	}

	public void setLength(float length) {

		if (validInput(length)) {
			this.length = length;
		}
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		if (validInput(width)) {
			this.width = width;
		}
	}

}
