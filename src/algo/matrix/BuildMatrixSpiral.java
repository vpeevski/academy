package algo.matrix;

import java.util.Scanner;

import util.IOUtil;

public class BuildMatrixSpiral {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter columns number : ");
		int columns = scanner.nextInt();
		System.out.println("Enter rows number : ");
		int rows = scanner.nextInt();
		
		int[][] matrix = new int [rows][columns];
		int number = 1;
		
		int start = 0;
		int endColumn = columns - 1;
		int endRow = rows - 1;
		
		for (int r = 0; r <= rows / 2 && start <= endColumn && start <= endRow; r++) {
			for (int c = start; c <= endColumn; c++) {
				matrix[r][c] = number++;
			}
			
			for (int j = start + 1; j <= endRow; j++) {
				matrix[j][endColumn] = number++;
			}
			
			for (int c = endColumn - 1; c >= start; c--) {
				matrix[endRow][c] = number++;
			}
			
			for (int j = endRow - 1; j > start; j--) {
				matrix[j][start] = number++;
			}
			
			
			start++;
			endColumn--;
			endRow--;
		}
		
		IOUtil.print(matrix);
		
		
	}
}
