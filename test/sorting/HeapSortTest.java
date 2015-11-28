package sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class HeapSortTest extends AbstractTest {

  @Test
  public void testSortedArray() {
    HeapSort heapSort = new HeapSort();
    int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
    heapSort.sortForTime(sortedArray);
    assertArrayEquals(sortedArrayExpected, sortedArray);
  }

  @Test
  public void testResersedSortedArray() {
    HeapSort heapSort = new HeapSort();
    int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
    heapSort.sortForTime(reverseSortedArray);
    assertArrayEquals(sortedArrayExpected, reverseSortedArray);
  }

  @Test
  public void testBigArrayWithJavaInternalSort() {
    HeapSort heapSort = new HeapSort();
    int[] clone = arr.clone();
    Arrays.sort(clone);
    heapSort.sortForTime(arr);
    assertArrayEquals(clone, arr);
  }
  
  @Test
  public void testRandomArray() {
    HeapSort heapSort = new HeapSort();
    
    heapSort.sortForTime(randomArray);
    assertArrayEquals(randomArraySorted, randomArray);
  }

}
