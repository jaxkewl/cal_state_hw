package MartinHongWk6HW;

public abstract class Quadrilateral {
	/*
	 * a -------------- b | | | | | | | | c -------------- d
	 */

	private int[] aLoc = new int[2];
	private int[] bLoc = new int[2];
	private int[] cLoc = new int[2];
	private int[] dLoc = new int[2];

	public Quadrilateral(int[] a, int[] b, int[] c, int[] d) {
		aLoc = a;
		bLoc = b;
		cLoc = c;
		dLoc = d;
		System.out.println("Constructing quadrilateral");
	}

	public abstract void outputArea(); 
	
	public int[] getaLoc() {
		return aLoc;
	}

	public void setaLoc(int[] aLoc) {
		if (aLoc[0] > 0 && aLoc[1] > 0) {
			this.aLoc = aLoc;
		} else {
			throw new IllegalArgumentException("Enter positive int(a)");
		}
	}

	public int[] getbLoc() {
		return bLoc;
	}

	public void setbLoc(int[] bLoc) {
		if (bLoc[0] > 0 && bLoc[1] > 0) {
			this.bLoc = bLoc;
		} else {
			throw new IllegalArgumentException("Enter positive int(b)");
		}
	}

	public int[] getcLoc() {
		return cLoc;
	}

	public void setcLoc(int[] cLoc) {
		if (cLoc[0] > 0 && cLoc[1] > 0) {
			this.cLoc = cLoc;
		} else {
			throw new IllegalArgumentException("Enter positive int(c)");
		}
	}

	public int[] getdLoc() {
		return dLoc;
	}

	public void setdLoc(int[] dLoc) {
		if (dLoc[0] > 0 && dLoc[1] > 0) {
			this.dLoc = dLoc;
		} else {
			throw new IllegalArgumentException("Enter positive int(d)");
		}
	}

}
