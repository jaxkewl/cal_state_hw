package MartinHongWk5HW;

public class RectangleTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float width = 4.7f;
		float length = 13.6f;
		
		Rectangle rect = new Rectangle();
		
		System.out.println("Testing with good numbers");
		rect.setLength(length);
		rect.setWidth(width);
		rect.performCalculations();
		rect.displayCalculations();

		
		System.out.println("");
		System.out.println("Testing with bad numbers");
		width = 43.7f;
		length = -13.6f;
		
		rect = new Rectangle();
		
		
		rect.setLength(length);
		rect.setWidth(width);
		rect.performCalculations();
		rect.displayCalculations();		
		
	}

}
