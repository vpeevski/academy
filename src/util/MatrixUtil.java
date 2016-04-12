package util;

public final class MatrixUtil {
  
  private MatrixUtil () {}
  
  public static void print (int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      
      System.out.println();
    }
  }

}
