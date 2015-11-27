package sorting;

import sorting.time.TimeInterceptor;

public class SelectionSort extends AbstractSortWithTimer {

  public SelectionSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public SelectionSort( ) {
    super();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    SelectionSort sorter = new SelectionSort();
    sorter.sortForTime(arr);
  }

  @Override
  public void sort(int[] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        if (inputArray[i] > inputArray[j]) {
          swap(inputArray, i, j);
        }
      }
    }
  }

}
