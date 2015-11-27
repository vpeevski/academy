package sorting;


public class InstertionSort extends AbstractSortWithTimer {
  
  public InstertionSort() {
    super();
  }

  public static void main(String[] args) {
    InstertionSort sorter = new InstertionSort();
    sorter.sortForTime(arr);
  }

  @Override
  public void sort(int[] inputArray) {
    for (int i = 1; i < inputArray.length; i++) {
      int j = i - 1;
      while (j >= 0 && inputArray[j] > inputArray[j + 1]) {
        swap(inputArray, j, j + 1);
        j--;
      }
    }

  }

}
