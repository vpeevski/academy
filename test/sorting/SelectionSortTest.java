package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SelectionSortTest extends AbstractTest {

	@Test
	public void testSortedArray() {
		SelectionSort selectionSorter = new SelectionSort();
		int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
		selectionSorter.sortForTime(sortedArray);
		assertArrayEquals(sortedArrayExpected, sortedArray);
	}

	@Test
	public void testResersedSortedArray() {
		SelectionSort selectionSorter = new SelectionSort();
		int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		selectionSorter.sortForTime(reverseSortedArray);
		assertArrayEquals(sortedArrayExpected, reverseSortedArray);
	}

	@Override
	protected AbstractSortWithTimer provideSorter() {
		return new SelectionSort();
	}

}
