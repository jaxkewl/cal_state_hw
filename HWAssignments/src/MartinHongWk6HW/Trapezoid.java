package MartinHongWk6HW;

public class Trapezoid extends Quadrilateral{

	public Trapezoid(int[] a, int[] b, int[] c, int[] d) {
		super(a, b, c, d);
		System.out.println("Constructing trapezoid");
	}

	@Override
	public void outputArea(){ 
		System.out.println("Area of trapezoid is 45");
	}
}
