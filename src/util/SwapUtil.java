package util;

public final class SwapUtil {
	
	private SwapUtil () {}
	
	
	public static final <T> void swap(T[] arr, int index1, int index2) {
	    T temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	  }
	
	public static final void swap(int[][] arr, int firstElemRow, int firstElemCol, int secondElemRow, int secondElemCol) {
      int temp = arr[firstElemRow][firstElemCol];
      arr[firstElemRow][firstElemCol] = arr[secondElemRow][secondElemCol];
      arr[secondElemRow][secondElemCol] = temp;
    }
	
	public static final void swapColumns (int[][] arr, int firstColumnIndex, int secondColumnIndex) {
	  int rowsNumber = arr.length;
	  for (int i = 0; i < rowsNumber; i++) {
	    swap(arr, i, firstColumnIndex, i, secondColumnIndex);
	  }
    }

}
