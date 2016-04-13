package algo.matrix;

import java.util.Scanner;

import util.IOUtil;

public class BuildMatrixAsSnake {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter columns number : ");
		int columns = scanner.nextInt();
		System.out.println("Enter rows number : ");
		int rows = scanner.nextInt();

		int[][] matrix = new int[rows][columns];
		int numberToSet = 1;
		boolean isDirectionDown = true;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (isDirectionDown) {
					matrix[c][r] = numberToSet;
				} else {
					matrix[rows - c - 1][r] = numberToSet;
				}

				numberToSet++;
			}

			isDirectionDown = !isDirectionDown;
		}

		IOUtil.print(matrix);
	}

}
