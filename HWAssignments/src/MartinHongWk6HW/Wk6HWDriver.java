package MartinHongWk6HW;

public class Wk6HWDriver {

	public static void main(String[] args) {

		int length = 5;
		int[] a = { 0, 0 };
		int[] b = { 0, length };
		int[] c = { length, 0 };
		int[] d = { length, length };
		
		// Trapezoid
		Trapezoid trapezoid = new Trapezoid(a, b, c, d);
		trapezoid.outputArea();
		System.out.println();

		// Parallelogram
		Parallelogram parallelogram = new Parallelogram(a, b, c, d);
		parallelogram.outputArea();
		System.out.println();

		// Rectangle
		Rectangle rectangle = new Rectangle(a, b, c, d);
		rectangle.outputArea();
		System.out.println();

		// Square
		Square square = new Square(a, b, c, d);
		square.outputArea();

	}
}
