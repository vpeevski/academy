package sorting;

import sorting.time.TimeInterceptor;
import util.SwapUtil;

public class SelectionSort extends AbstractSortWithTimer {

  public SelectionSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public SelectionSort( ) {
    super();
  }

  @Override
  public <T extends Comparable<T>> void sort(T[] inputArray) {
    for (int i = 0; i < inputArray.length - 1; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        if (inputArray[i].compareTo(inputArray[j]) > 0) {
        	SwapUtil.swap(inputArray, i, j);
        }
      }
    }
  }

}
