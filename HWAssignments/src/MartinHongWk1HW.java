import java.util.Scanner;

/**
 * 
 */

/**
 * @author martin hong week1 HW
 *
 */
public class MartinHongWk1HW {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hi, welcome to Java");
		Scanner input = new Scanner(System.in);

		double number1 = 0.0;
		double number2 = 0.0;

		while (true) {
			// now ask the user for the two numbers
			System.out.print("Enter an integer: ");
			number1 = input.nextDouble();
			System.out.println("You entered " + number1 + "\n");

			System.out.print("Enter another integer: ");
			number2 = input.nextDouble();
			System.out.println("You entered " + number2 + "\n");

			double numSum = number1 + number2;
			System.out.println(number1 + " + " + number2 + " = " + numSum);

			double numDiff = number1 - number2;
			System.out.println(number1 + " - " + number2 + " = " + numDiff);

			double numProduct = number1 * number2;
			System.out.println(number1 + " * " + number2 + " = " + numProduct);

			if (0 == number2) {
				System.out.println("Div by 0 error!");
			} else {
				double numQuotient = number1 / number2;
				System.out.println(number1 + " / " + number2 + " = "
						+ numQuotient);
			}
			System.out.println("==============================");
		}
	}
}
