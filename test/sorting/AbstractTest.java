package sorting;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sorting.time.Timer;

import org.junit.Test;

import util.RandomGenerator;

public abstract class AbstractTest {
  
  protected final Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10};
  
  protected final Integer[] reverseSortedArray = {10, 9, 8, 7, 6, 5, 4, 3, 3, 2, 2, 1, 1};
  
  private final static int ITERATIONS = 1000;
  
  protected final Logger _logger = LoggerFactory.getLogger(this.getClass());
  
  protected Integer[] randomArray;
  
  protected Integer[] randomArrayClone1;

  protected Integer[] randomArrayClone2;
  
  

  @Test
  public void testRandomArrayMultipleTimes () {
     Timer timer = new Timer(); 
     timer.startTime();
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
	 
	 timer.endTime();
	 System.out.println("Sorting " + ITERATIONS +" arrays " + "with " + this.getClass().getName() + " for : " + timer.executingTime() + " msec.");
  }
  
  private void testRandomArraySort() {
	AbstractSortWithTimer sorter = provideSorter();
    
	sorter.sortForTime(randomArray);
    Arrays.sort(randomArrayClone1);
    try {
    	assertArrayEquals(randomArrayClone1, randomArray);
    } catch (AssertionError assertError ){
    	AssertionError notSortedAssertError = new AssertionError("Input array: " + Arrays.toString(randomArrayClone2) + "\n" +"Sorted array:" + Arrays.toString(randomArray));
    	notSortedAssertError.initCause(assertError);
    	throw notSortedAssertError;
    }
  }
  
  protected abstract AbstractSortWithTimer provideSorter();
}
	
