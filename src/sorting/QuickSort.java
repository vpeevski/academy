package sorting;

import sorting.time.TimeInterceptor;
import sorting.time.Timer;

public class QuickSort extends AbstractSortWithTimer {

  public QuickSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public QuickSort() {
    super();
  }

  public static void main(String[] args) {
    QuickSort sorter = new QuickSort(new Timer());
    sorter.sortForTime(arr);
  }

  @Override
  public void sort(int[] inputArray) {
    sort(inputArray, 0, inputArray.length - 1);
  }

  private void sort(int[] input, int startIndex, int endIndex) {
    if (startIndex >= endIndex - 1) { return; }

    //System.out.println(Arrays.toString(input));

    int pivot = input[startIndex];
    int i = startIndex, j = endIndex;
    while (i < j) {

      int jElem = input[j];
      while (jElem > pivot && i < j) {
        j--;
      }

      int iElem = input[i];
      
      
      if (i < j) {
        input[i] = jElem;
        i++;
      }

      while (input[i] < pivot && i < j) {
        i++;
      }

      iElem = input[i];
      jElem = input[j];
      if (i < j) {
        input[j] = iElem;
        j--;
      }
      
      
    }

    input[i] = pivot;

    if (startIndex < i - 1) {
      sort(input, startIndex, i - 1);
    }

    if (endIndex > i) {
      sort(input, i + 1, endIndex);
    }
  }

}
