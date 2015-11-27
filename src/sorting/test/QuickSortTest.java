package sorting.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import sorting.QuickSort;

public class QuickSortTest extends AbstractTest {

  @Test
  public void testSortedArray() {
    QuickSort quickSorter = new QuickSort();
    int[] sortedArrayExpected = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10};
    quickSorter.sortForTime(sortedArray);
    assertArrayEquals(sortedArrayExpected, sortedArray);
  }
  
  @Test
  public void testResersedSortedArray() {
    QuickSort quickSorter = new QuickSort();
    int[] sortedArrayExpected = {1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
    quickSorter.sortForTime(reverseSortedArray);
    assertArrayEquals(sortedArrayExpected, reverseSortedArray);
  }
  
  @Test
  public void testBigArrayWithJavaInternalSort() {
    QuickSort quickSorter = new QuickSort();
    int[] clone = arr.clone();
    Arrays.sort(clone);
    quickSorter.sortForTime(arr);
    assertArrayEquals(clone, arr);
  }
  
  @Test
  public void testRandomArraySort() {
    QuickSort quickSorter = new QuickSort();
    
    quickSorter.sortForTime(randomArray);
    assertArrayEquals(randomArraySorted, randomArray);
  }
  
  

}
