package sorting;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class BulbeSortTest extends AbstractTest {

	@Test
	public void testSortedArray() {
		BubleSort bubleSorter = new BubleSort();
		int[] sortedArrayExpected = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10 };
		bubleSorter.sortForTime(sortedArray);
		assertArrayEquals(sortedArrayExpected, sortedArray);
	}

	@Test
	public void testResersedSortedArray() {
		BubleSort bubleSorter = new BubleSort();
		int[] sortedArrayExpected = { 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10 };
		bubleSorter.sortForTime(reverseSortedArray);
		assertArrayEquals(sortedArrayExpected, reverseSortedArray);
	}

	@Override
	protected AbstractSort provideSorter() {
		return new BubleSort();
	}

}
