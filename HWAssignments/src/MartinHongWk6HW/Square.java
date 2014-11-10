package MartinHongWk6HW;

public class Square extends Rectangle {

	public Square(int[] a, int[] b, int[] c, int[] d) {
		super(a, b, c, d);
		
		System.out.println("Constructing square");
	}

	@Override
	public void outputArea(){ 
		System.out.println("Area of square is 25");
	}
}
