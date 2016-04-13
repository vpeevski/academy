package algo.arrays;

import java.util.Scanner;

import util.IOUtil;

public class FibLikeArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter a number : ");
		int number = scanner.nextInt();
		int[] array = new int[10];
		array[0] = number;
		array[1] = number;
		for (int i = 2; i < array.length; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		IOUtil.print(array);

	}

}
