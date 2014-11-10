public class MartinHongWk3HW {

	private static void writeTriangleA() {
		System.out.println("(a)");
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println("");
		}
	}

	private static void writeTriangleB() {
		System.out.println("(b)");
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j <= 10; j++) {
				System.out.print('*');
			}
			System.out.println("");
		}
	}

	private static void writeTriangleC() {
		System.out.println("(c)");
		for (int i = 1; i <= 10; i++) {

			// add the space
			for (int k = 1; k <= i; k++) {
				System.out.print(' ');
			}

			// add the star
			for (int j = i; j <= 10; j++) {
				System.out.print('*');
			}
			System.out.println("");
		}
	}

	private static void writeTriangleD() {
		System.out.println("(d)");
		for (int i = 1; i <= 10; i++) {

			int spaceCounter = 10 - i;

			// add the space
			for (int k = 1; k <= spaceCounter; k++) {
				System.out.print(' ');
			}

			// add the star
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.print('*');
		// System.out.println("");
		// System.out.print(' ');

		// do exercise 5-15 in the book

		// triangle printing program using for loops

		writeTriangleA();
		System.out.println("");
		writeTriangleB();
		System.out.println("");
		writeTriangleC();
		System.out.println("");
		writeTriangleD();
	}

}
