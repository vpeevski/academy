package sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.junit.Test;

import util.RandomGenerator;

public abstract class AbstractTest {
  
  protected final int[] sortedArray = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10};
  
  protected final int[] reverseSortedArray = {10, 9, 8, 7, 6, 5, 4, 3, 3, 2, 2, 1, 1};
  
  private final static int ITERATIONS = 1000;
  
  protected final Logger _logger = Logger.getLogger(this.getClass().getName());;
  
  protected int[] randomArray;
  
  protected int[] randomArrayClone1;

  protected int[] randomArrayClone2;
  
  

  @Test
  public void testRandomArrayMultipleTimes () {
	 for (int i = 0; i < ITERATIONS; i++) {
		 randomArray = RandomGenerator.genRandomArray();
		 randomArrayClone1 = randomArray.clone();
		 randomArrayClone2 = randomArray.clone();
		 try {
			 testRandomArraySort();
		 } catch (AssertionError asserError) {
			 _logger.error("Iteration (" + i + ") " + "\n" + asserError.getCause().getMessage() + "\n" +  asserError.getMessage()); 
			 throw asserError;
		 }
	 }
  }
  
  private void testRandomArraySort() {
	AbstractSortWithTimer sorter = provideSorter();
    
	sorter.sortForTime(randomArray);
    Arrays.sort(randomArrayClone1);
    try {
    	assertArrayEquals(randomArrayClone1, randomArray);
    } catch (AssertionError assertError ){
    	AssertionError notSortedAssertError = new AssertionError("Input array: " + Arrays.toString(randomArrayClone2) + "\n" +"Sorted array:" + Arrays.toString(randomArray), assertError);
    	throw notSortedAssertError;
    }
  }
  
  protected abstract AbstractSortWithTimer provideSorter();
}
	
