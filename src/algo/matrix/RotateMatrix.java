package algo.matrix;

import util.IOUtil;
import util.SwapUtil;

public class RotateMatrix {

  static int[][] inputMatrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

  public static int[][] rotateCW(int[][] mat) {
    final int M = mat.length;
    final int N = mat[0].length;
    int[][] ret = new int[N][M];
    for (int r = 0; r < M; r++) {
      for (int c = 0; c < N; c++) {
        ret[c][M - 1 - r] = mat[r][c];
      }
    }
    return ret;
  }

  public static void rotateWithTransponation(int[][] matrix) {
    TransponeMatrix.transpone(matrix);
    int columnsNumber = matrix[0].length;
    for (int i = 0; i < columnsNumber / 2; i++) {
      SwapUtil.swapColumns(matrix, i, columnsNumber - 1 - i);
    }
  }

  public static void main(String[] args) {
    IOUtil.print(inputMatrix);
    int[][] rotatedMatrix = RotateMatrix.rotateCW(inputMatrix);
    System.out.println("############################################");
    IOUtil.print(rotatedMatrix);
    
    RotateMatrix.rotateWithTransponation(inputMatrix);
    System.out.println("############################################");
    IOUtil.print(inputMatrix);
  }

}
