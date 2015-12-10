package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HeapSortTest extends AbstractTest {

	@Test
	public void testSortedArray() {
		HeapSort heapSort = new HeapSort();
		int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
		heapSort.sortForTime(sortedArray);
		try  {
			assertArrayEquals(sortedArrayExpected, sortedArray);
		} catch (Throwable throwable) {
			_logger.error("Arrays not Equal", throwable); 
			throw new AssertionError(throwable);
		}
	}

	@Test
	public void testResersedSortedArray() {
		HeapSort heapSort = new HeapSort();
		int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		heapSort.sortForTime(reverseSortedArray);
		try  {
			assertArrayEquals(sortedArrayExpected, reverseSortedArray);
		} catch (Throwable throwable) {
			_logger.error("Arrays not Equal", throwable); 
			throw new AssertionError(throwable);
		}
	}

	@Override
	protected AbstractSortWithTimer provideSorter() {
		return new HeapSort();
	}
	
	@Test
	public void testConcreteArray () {
		int[] array = {9, 3, 3, 5, 9, 1, 2, 4};
		HeapSort heapSorter = new HeapSort();
		heapSorter.sort(array);
		int[] arraySorted = {1, 2, 3, 3, 4, 5, 9, 9};
		try  {
			assertArrayEquals(arraySorted, array);
		} catch (Throwable throwable) {
			_logger.error("Arrays not Equal", throwable);
			throw new AssertionError(throwable);
		}
	}

}
