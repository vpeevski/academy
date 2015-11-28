package sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest extends AbstractTest {

  @Test
  public void testSortedArray() {
    MergeSort mergeSorter = new MergeSort();
    int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
    mergeSorter.sortForTime(sortedArray);
    assertArrayEquals(sortedArrayExpected, sortedArray);
  }

  @Test
  public void testResersedSortedArray() {
    MergeSort mergeSorter = new MergeSort();
    int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
    mergeSorter.sortForTime(reverseSortedArray);
    assertArrayEquals(sortedArrayExpected, reverseSortedArray);
  }

  @Test
  public void testBigArrayWithJavaInternalSort() {
    MergeSort mergeSorter = new MergeSort();
    int[] clone = arr.clone();
    Arrays.sort(clone);
    mergeSorter.sortForTime(arr);
    assertArrayEquals(clone, arr);
  }
  
  @Test
  public void testRandomArraySort() {
    MergeSort mergeSorter = new MergeSort();
    
    mergeSorter.sortForTime(randomArray);
    assertArrayEquals(randomArraySorted, randomArray);
  }

}
