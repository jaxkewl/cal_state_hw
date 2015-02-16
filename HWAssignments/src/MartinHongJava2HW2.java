import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class MartinHongJava2HW2 {

	// Do Exercise 17.9 in "Java, How to program, Ninth Edition" book.

	// (Student Poll) Figure 7.8 contains an array of survey responses that is
	// hard coded into the program. Suppose we wish to process survey results
	// that are stored in a file. This exercise requires two separate programs.
	// First, create an application that prompts the user for survey responses
	// and outputs each response to a file. Use a Formatter to create a file
	// called numbers.txt. Each integer should be written using method format.
	// Then modify the program of Fig. 7.8 to read the survey responses from
	// numbers.txt. The responses should be read from the file by using a
	// Scanner. Method nextInt should be used to input one integer at a time
	// from the file. The program should continue to read responses until it
	// reaches the end of file. The results should be output to the text file
	// "output.txt".

	private String numbersFilePath = "./numbers.txt"; // contains user input
															// ratings
	private String outputFilePath = "./src/output.txt"; // contains read in
														// values from
														// numbers.txt

	private Formatter formatter;

	public void readRatingsFromFile() {
		// this array contains the ratings that was read from the numbers.txt
		// file
		int[] readRatings = new int[6];

		// read in the numbers.txt file using Scanner class
		Scanner in;
		try {
			in = new Scanner(new File(numbersFilePath));

			String header = in.next() + " " + in.next(); // capture the header
															// information

			// read in each rating index and rating
			while (in.hasNext()) {
				int index = in.nextInt();
				int rating = in.nextInt();
				readRatings[index] = rating;
			}
			writeOutRatings(readRatings, outputFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getRatingsFromUser() {
		// this array contains the ratings the user inputted
		int[] userRatings = new int[6];

		// use the scanner class to get ratings from the user
		Scanner in = new Scanner(System.in);

		int rating = 10;

		while (0 != rating) {

			System.out
					.println("Enter a rating 1-5 where 5 is the highest. 0 to exit");
			rating = in.nextInt();

			if (0 != rating && rating >= 1 && rating <= 5) {
				// increment the rating
				userRatings[rating]++;
			} else if (0 == rating) {
				System.out.println("Exiting...");
			} else if (rating < 1 || rating > 5) {
				System.out.println("Out of bounds!");
			}
		}
		writeOutRatings(userRatings, numbersFilePath);
	}

	private void writeOutRatings(int[] ratings, String filePath) {
		try {
			// attempt to write out the results in a nice format
			// also could have used convenience method printf
			formatter = new Formatter(filePath);
			formatter.format("%s %10s%n", "Rating", "Frequency");

			for (int i = 1; i <= 5; i++) {
				formatter.format("%6d  %10d%n", i, ratings[i]);
			}
			formatter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MartinHongJava2HW2 hw2 = new MartinHongJava2HW2();
		
		//get user inputs and output to a file
		hw2.getRatingsFromUser();
		
		//read in inputs from a file and then output to a file
		hw2.readRatingsFromFile();
	}

}
