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
		int[] array = {316, 636, 923, 265, 862, 200, 1006, 826, 328, 974};
		QuickSort quickSorter = new QuickSort();
		quickSorter.sort(array);
		int[] arraySorted = {200, 265, 316, 328, 636, 826, 862, 923, 974, 1006};
		assertArrayEquals(arraySorted, array);
	}

}
