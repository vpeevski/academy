package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class InsertionSortTest extends AbstractTest {

	@Test
	public void testSortedArray() {
		InstertionSort insertionSorter = new InstertionSort();
		int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
		insertionSorter.sortForTime(sortedArray);
		assertArrayEquals(sortedArrayExpected, sortedArray);
	}

	@Test
	public void testResersedSortedArray() {
		InstertionSort insertionSorter = new InstertionSort();
		int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		insertionSorter.sortForTime(reverseSortedArray);
		assertArrayEquals(sortedArrayExpected, reverseSortedArray);
	}

	@Override
	protected AbstractSort provideSorter() {
		return new InstertionSort();
	}

}
