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
  public void sort(int[] inputArray) {
    mergeSort(inputArray);
  }

  private void mergeSort(int[] arr) {
    int size = arr.length;
    if (size < 2)
      return;
    int mid = size / 2;
    int leftSize = mid;
    int rightSize = size - mid;
    int[] left = new int[leftSize];
    int[] right = new int[rightSize];
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

  public void merge(int[] left, int[] right, int arr[]) {
    int leftSize = left.length;
    int rightSize = right.length;
    int i = 0, j = 0, k = 0;
    while (i < leftSize && j < rightSize) {
      if (left[i] <= right[j]) {
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