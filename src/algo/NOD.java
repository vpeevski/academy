package algo;

import util.MathUtil;

/**
 * 
 * Uses Evklid algorithm to find GCD
 * 
 * @author vpeevski
 *
 */
public class NOD {

	public int nod(int a, int b) {

		int bigger = MathUtil.max(a, b);
		int less = MathUtil.min(a, b);

		int rest = bigger % less;

		while (rest > 0) {
			bigger = less;
			less = rest;
			rest = bigger % less;
		}

		System.out.println("NOD of " + a + " and " + b + " is: " + less);

		return less;
	}

	public int nodr(int a, int b) {

		if (a == 0) {
			return b;
		}
		return nodr(b % a, a);
	}
	
	public int nodDiv(int a, int b) {
		System.out.print("NOD of " + a + " and " + b + " is: "); // mention this output is in the beginning

		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		System.out.print(a);

		return a;
	}
	
	public int nodNaive (int a, int b) {
		int less = MathUtil.min(a, b);
		while (less >= 1) {
			if (a % less == 0 && b % less == 0) {
				return less;
			}
			
			less--;
		}
		
		return 1;
	}

}
