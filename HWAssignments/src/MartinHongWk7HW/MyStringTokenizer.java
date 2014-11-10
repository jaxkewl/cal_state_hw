package MartinHongWk7HW;

import java.util.Scanner;
import java.util.StringTokenizer;

public class MyStringTokenizer {

	public static void main(String[] args) {

		System.out.println("Enter a line of text");

		Scanner inputScanner = new Scanner(System.in);
		String userInput = inputScanner.nextLine();

		StringTokenizer sTokenizer = new StringTokenizer(userInput);
		String reversedString = "";
		while (sTokenizer.hasMoreTokens()) {
			reversedString = sTokenizer.nextToken() + " " + reversedString;
		}

		inputScanner.close();

		System.out.println(userInput);
		System.out.println(reversedString);
		
		
	}
}
