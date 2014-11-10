public class MartinHongWk4HW {

	// this contains how many of each group were in sales.
	private int[] salesCounter = new int[9];

	// contains the current salesman sales
	private int[] salesAmount;

	public MartinHongWk4HW(int[] salesAmount) {

		this.salesAmount = salesAmount;
	}

	private void saveSaleAmount(int amount) {
		/*
		 * a) $200-299
		 * 
		 * b) $300-399
		 * 
		 * c) $400-499
		 * 
		 * d) $500-599
		 * 
		 * e) $600-699
		 * 
		 * f) $700-799
		 * 
		 * g) $800-899
		 * 
		 * h) $900-999
		 * 
		 * i) $1000 and over
		 */

		if ((amount >= 200) && (amount <= 299)) {
			// increment a
			salesCounter[0]++;
		} else if ((amount >= 300) && (amount <= 399)) {
			// increment b
			salesCounter[1]++;
		} else if ((amount >= 400) && (amount <= 499)) {
			// increment c
			salesCounter[2]++;
		} else if ((amount >= 500) && (amount <= 599)) {
			// increment d
			salesCounter[3]++;
		} else if ((amount >= 600) && (amount <= 699)) {
			// increment e
			salesCounter[4]++;
		} else if ((amount >= 700) && (amount <= 799)) {
			// increment f
			salesCounter[5]++;
		} else if ((amount >= 800) && (amount <= 899)) {
			// increment g
			salesCounter[6]++;
		} else if ((amount >= 900) && (amount <= 999)) {
			// increment h
			salesCounter[7]++;
		} else if (amount >= 1000) {
			// increment i
			salesCounter[8]++;
		} else {
			System.out.println("Salesman made less than $200!");
		}

	}

	public void determineSales() {

		System.out.println("");
		System.out.println("Outputting Sales information");
		
		for (int i = 0; i < salesAmount.length; i++) {

			// go through each salesman sales
			int currentSales = salesAmount[i];

			// calculate how much this person earned
			double amountEarnedDbl = 200 + 0.09 * currentSales;
			int amountEarned = (int) amountEarnedDbl;

			// now keep track of it.

			saveSaleAmount(amountEarned);

		}

		for (int i = 0; i < salesCounter.length; i++) {

			int count = salesCounter[i];

			switch (i) {

			// determine how many in each category was earned
			case 0:
				System.out.println(count + " Earned between $200-$299");
				break;
			case 1:
				System.out.println(count + " Earned between $300-$399");
				break;
			case 2:
				System.out.println(count + " Earned between $400-$499");
				break;
			case 3:
				System.out.println(count + " Earned between $500-$599");
				break;
			case 4:
				System.out.println(count + " Earned between $600-$699");
				break;
			case 5:
				System.out.println(count + " Earned between $700-$799");
				break;
			case 6:
				System.out.println(count + " Earned between $800-$899");
				break;
			case 7:
				System.out.println(count + " Earned between $900-$999");
				break;
			case 8:
				System.out.println(count + " Earned more than $1,000");
				break;
			}
		}
		System.out.println("");
	}

	public void outputSales() {

		System.out.println("");
		System.out.println("Current sales");
		for (int i = 0; i < salesAmount.length; i++) {

			System.out.println("Salesman #" + (i + 1) + "\t Total Sales: $"
					+ salesAmount[i]);
		}
		
	}

	/*
	 * 
	 * Do Exercise 7-10 in "Java, How to program, Ninth Edition" book.
	 * 
	 * (Sales Commissions) Use a one-dimensional array to solve the following
	 * problem: A company pays its salespeople on a commission basis. The
	 * salespeople receive $200 per week plus 9% of their gross sales for that
	 * week. For example, a salesperson who grosses $5000 in sales in a week
	 * receives $200 plus 9% of $5000, or a total of $650.Write an application
	 * (using an array of counters) that determines how many of the salespeople
	 * earned salaries in each of the following ranges (assume that each
	 * salesperson’s salary is truncated to an integer amount):
	 */

	public static void main(String[] args) {

		int[] salesAmount = { 4000, 6000, 8200, 9200, 7800, 5600, 10000, 7865,
				5677, 6543, 3424, 2356, 5676, 5676, 7666, 5677 };

		MartinHongWk4HW wk4hw = new MartinHongWk4HW(salesAmount);
		wk4hw.outputSales();
		wk4hw.determineSales();

	}

}
