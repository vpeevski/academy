package util;

import java.util.Scanner;

public final class IOUtil {

	private IOUtil() {
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static int[] readArray() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size of the array : ");
		int n = scanner.nextInt();

		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.println("Enter element " + (i + 1) + " : ");
			int nextNumber = scanner.nextInt();
			array[i] = nextNumber;

		}

		return array;
	}

}
