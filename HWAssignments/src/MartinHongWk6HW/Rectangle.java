package MartinHongWk6HW;

public class Rectangle extends Parallelogram{

	public Rectangle(int[] a, int[] b, int[] c, int[] d) {
		super(a, b, c, d);
		System.out.println("Constructing rectangle");
	}
	
	@Override
	public void outputArea(){ 
		System.out.println("Area of rectangle is 10");
	}

}
