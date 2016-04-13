package algo.arrays;

import java.util.Scanner;

public class InputHalfElements {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		int n;
		do {
			System.out.println("Въведете размер на масива кратен на 2 : ");
			n = scanner.nextInt();
		} while (n % 2 != 0);
		
		int[] array = new int[n];
		for (int i = 0; i < n / 2; i++) {
			System.out.println("Въведете " + (i + 1) + "-я елемент : ");
			array[i] = scanner.nextInt();
			array[i + n / 2] = array[i];
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
			
		
		
		
	}

}
