package algo.arrays;

import util.IOUtil;

public class SmallestNumberDividedTo3 {
	
	public static void main(String[] args) {
		int[] array = IOUtil.readArray();
		
		int minDividedBy3 = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			if (array[i] % 3 == 0 && array[i] < minDividedBy3) {
				minDividedBy3 = array[i];
			}
		}
		
		System.out.println();
		if (minDividedBy3 == Integer.MAX_VALUE) {
			System.out.println("None of the input numbers is divided by 3");
		} else {
			System.out.println("Minimal number divided by 3 is : " + minDividedBy3);
		}
	}

}
