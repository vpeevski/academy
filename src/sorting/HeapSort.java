package sorting;

public class HeapSort extends AbstractSortWithTimer {

  @Override
  public void sort(int[] inputArray) {
    heapSort(inputArray, inputArray.length);

  }
  
  private void heapSort(int numbers[], int array_size)
  {
    for (int i = (array_size / 2)-1; i >= 0; i--) {
      siftDown(numbers, i, array_size);
    }

    for (int i = array_size-1; i >= 1; i--) {
      swap(numbers, 0, i);
      siftDown(numbers, 0, i-1);
    }
  }


  private void siftDown(int numbers[], int root, int bottom)
  {
    int maxChild;

    boolean done = false;
    while ((root*2 <= bottom) && (!done))
    {
      if (root*2 == bottom)
        maxChild = root * 2;
      else if (numbers[root * 2] > numbers[root * 2 + 1])
        maxChild = root * 2;
      else
        maxChild = root * 2 + 1;

      if (numbers[root] < numbers[maxChild])
      {
        swap(numbers, root, maxChild);
        root = maxChild;
      }
      else
        done = true;
    }
  }

}
