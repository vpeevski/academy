package algo.matrix;

import util.IOUtil;
import util.SwapUtil;

public class TransponeMatrix {
  
  static int[][] inputMatrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
  
  public static void transpone (int [][] matrix) {
    int n = matrix[0].length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) { 
        SwapUtil.swap(matrix, i, j, j, i);
        
      }
    }
  }
  
  public static void main(String[] args) {
    IOUtil.print(inputMatrix);
    TransponeMatrix.transpone(inputMatrix);
    System.out.println("###############");
    IOUtil.print(inputMatrix);
  }

}
