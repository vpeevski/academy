package sorting;

import static org.junit.Assert.assertArrayEquals;

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

	@Override
	protected AbstractSort provideSorter() {
		return new MergeSort();
	}

}
