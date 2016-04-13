package algo.matrix;

import java.util.Scanner;

import util.MatrixUtil;

public class BuildMatrixByDiagonal {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter columns number : ");
		int columns = scanner.nextInt();
		System.out.println("Enter rows number : ");
		int rows = scanner.nextInt();
		
		int[][] matrix = new int [rows][columns];
		int numberToSet = 1;
		
		int r = rows - 1;
		int c = 0;
		
		
		
		while (r >= 0 && c < columns) {
			int rr = r;
			int cc = c;
			while (rr < rows && cc < columns) {
				matrix[rr][cc] = numberToSet;
				numberToSet++;
				rr++;
				cc++;
			}
			
			if ( r > 0) {
				r--;
			} else {
				c++;
			}
			
			
		}
		
		MatrixUtil.print(matrix);
	}

}
