package sorting;

import util.SwapUtil;


public class InstertionSort extends AbstractSortWithTimer {
  
  public InstertionSort() {
    super();
  }

  @Override
  public <T extends Comparable<T>> void sort(T[] inputArray) {
    for (int i = 1; i < inputArray.length; i++) {
      for (int j = i - 1; j >= 0 && inputArray[j].compareTo(inputArray[j + 1]) > 0; j--) {
    	SwapUtil.swap(inputArray, j, j + 1);
      }
    }

  }

}
