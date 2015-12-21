package sorting;

import sorting.time.TimeInterceptor;

public class QuickSort extends AbstractSortWithTimer {

  public QuickSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public QuickSort() {
    super();
  }

  @Override
  public <T extends Comparable<T>> void sort(T[] inputArray) {
    sort(inputArray, 0, inputArray.length - 1);
  }

  private <T extends Comparable<T>> void sort(T[] input, int startIndex, int endIndex) {
    if (startIndex >= endIndex) { return; }

    //System.out.println(Arrays.toString(input));

    T pivot = input[startIndex];
    int i = startIndex, j = endIndex;
    while (i < j) {

      while (input[j].compareTo(pivot) >= 0  && i < j) {
        j--;
      }
      
      if (i < j) {
        input[i] = input[j];
        i++;
      }

      while (input[i].compareTo(pivot) <= 0 && i < j) {
        i++;
      }
      
      if (i < j) {
        input[j] = input[i];
        j--;
      }
      
      
    }

    input[i] = pivot;

    
    sort(input, startIndex, j - 1);
    sort(input, i + 1, endIndex);
    
  }

}
