package sorting;

import sorting.time.TimeInterceptor;
import util.SwapUtil;

public final class BubleSort extends AbstractSortWithTimer {

  public BubleSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public BubleSort() {
    super();
  }

  @Override
  public <T extends Comparable<T>> void sort(T[] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
      for (int j = 0; j < inputArray.length - 1 - i; j++) {
        if (inputArray[j].compareTo(inputArray[j + 1]) > 0) {
          SwapUtil.swap(inputArray, j, j + 1);
        }
      }
    }

  }

}
