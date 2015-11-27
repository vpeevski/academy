package sorting;

import sorting.time.TimeInterceptor;

public final class BubleSort extends AbstractSortWithTimer {

  public BubleSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public BubleSort() {
    super();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    BubleSort bubleSort = new BubleSort();
    bubleSort.sortForTime(arr);
  }

  @Override
  public void sort(int[] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
      for (int j = 0; j < inputArray.length - 1 - i; j++) {
        if (inputArray[j] > inputArray[j + 1]) {
          swap(inputArray, j, j + 1);
        }
      }
    }

  }

}
