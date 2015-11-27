package sorting.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import sorting.BubleSort;

public class BulbeSortTest extends AbstractTest {

  @Test
  public void testSortedArray() {
    BubleSort bubleSorter = new BubleSort();
    int[] sortedArrayExpected = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10};
    bubleSorter.sortForTime(sortedArray);
    assertArrayEquals(sortedArrayExpected, sortedArray);
  }
  
  @Test
  public void testResersedSortedArray() {
    BubleSort bubleSorter = new BubleSort();
    int[] sortedArrayExpected = {1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
    bubleSorter.sortForTime(reverseSortedArray);
    assertArrayEquals(sortedArrayExpected, reverseSortedArray);
  }
  
  @Test
  public void testBigArrayWithJavaInternalSort() {
    BubleSort bubleSorter = new BubleSort();
    int[] clone = arr.clone();
    Arrays.sort(clone);
    bubleSorter.sortForTime(arr);
    assertArrayEquals(clone, arr);
  }
  
  @Test
  public void testRandomArraySort() {
    BubleSort bubleSorter = new BubleSort();
    
    bubleSorter.sortForTime(randomArray);
    assertArrayEquals(randomArraySorted, randomArray);
  }

}
