package sorting;

import sorting.time.TimeInterceptor;

public class MergeSort extends AbstractSortWithTimer {

  public MergeSort(TimeInterceptor timeInterceptor) {
    super(timeInterceptor);
  }
  
  public MergeSort() {
    super();
  }

  @Override
  public <T extends Comparable<T>> void sort(T[] inputArray) {
    mergeSort(inputArray);
  }

  private <T extends Comparable<T>> void mergeSort(T[] arr) {
    int size = arr.length;
    if (size < 2)
      return;
    int mid = size / 2;
    int leftSize = mid;
    int rightSize = size - mid;
    Comparable[] left =  new Comparable[leftSize];
    Comparable[] right = new Comparable[rightSize];
    for (int i = 0; i < mid; i++) {
      left[i] = arr[i];

    }
    for (int i = mid; i < size; i++) {
      right[i - mid] = arr[i];
    }
    mergeSort(left);
    mergeSort(right);
    merge(left, right, arr);
  }

  public <T extends Comparable<T>> void merge(T[] left, T[] right, T arr[]) {
    int leftSize = left.length;
    int rightSize = right.length;
    int i = 0, j = 0, k = 0;
    while (i < leftSize && j < rightSize) {
      if (left[i].compareTo(right[j])  <= 0) {
        arr[k] = left[i];
        i++;
        k++;
      } else {
        arr[k] = right[j];
        k++;
        j++;
      }
    }
    while (i < leftSize) {
      arr[k] = left[i];
      k++;
      i++;
    }
    while (j < rightSize) {
      arr[k] = right[j];
      k++;
      j++;
    }
  }
}