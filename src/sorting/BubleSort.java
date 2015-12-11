package sorting;

import sorting.time.TimeInterceptor;

public final class BubleSort extends AbstractSortWithTimer {

  public BubleSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public BubleSort() {
    super();
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
