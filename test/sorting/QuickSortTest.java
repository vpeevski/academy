package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class QuickSortTest extends AbstractTest {

	@Test
	public void testSortedArray() {
		QuickSort quickSorter = new QuickSort();
		int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
		quickSorter.sortForTime(sortedArray);
		assertArrayEquals(sortedArrayExpected, sortedArray);
	}

	@Test
	public void testResersedSortedArray() {
		QuickSort quickSorter = new QuickSort();
		int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		quickSorter.sortForTime(reverseSortedArray);
		assertArrayEquals(sortedArrayExpected, reverseSortedArray);
	}

	@Override
	protected AbstractSort provideSorter() {
		return new QuickSort();
	}
	
	@Test
	public void testConcreteArray () {
		int[] array = {9,3,3,3,9};
		QuickSort quickSorter = new QuickSort();
		quickSorter.sort(array);
		int[] arraySorted = {3, 3, 3, 9, 9};
		assertArrayEquals(arraySorted, array);
	}

}
