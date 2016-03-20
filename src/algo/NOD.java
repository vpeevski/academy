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
	
	public int nodMany (int ... numbers) {
		if (numbers.length == 0) throw new IllegalArgumentException("NOD operation is not definet for empty value : " + numbers); 
		if (numbers.length == 1) return numbers[0]; 
		
		int result = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (result == 0) {
				result = nod (numbers[0], numbers[1]);
			} else {
				result = nod(result, numbers[i + 1]);
			}
		}
		
		return result;
	}
	
	public int nodManyR (int current, int[] numbers) {
		if (numbers.length == 0) throw new IllegalArgumentException("NOD operation is not definet for empty value : " + numbers); 
		if (numbers.length == 1) return numbers[0];
		if (current == numbers.length - 2) return nod (numbers[current], numbers[current + 1]);
		
		return nodManyR(++current, numbers);
	}

}
