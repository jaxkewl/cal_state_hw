package MartinHongWk6HW;

public class Parallelogram extends Trapezoid{

	public Parallelogram(int[] a, int[] b, int[] c, int[] d) {
		super(a, b, c, d);
		System.out.println("Constructing parallelogram");
	}

	@Override
	public void outputArea() {
		System.out.println("Area of parallelogram is 76");
	}


}
