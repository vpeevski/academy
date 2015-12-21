package sorting;

import util.HeapUtil;
import util.SwapUtil;

public class HeapSort extends AbstractSortWithTimer {

	@Override
	public <T extends Comparable<T>> void sort(T[] inputArray) {
		heapSort(inputArray);

	}

	private <T extends Comparable<T>> void heapSort(T numbers[]) {
		HeapUtil.buildMaxHeap(numbers);
		
		for (int i = numbers.length - 1; i >= 0; i--) {
			SwapUtil.swap(numbers, 0, i);
			HeapUtil.maxHeapifyRoot(numbers, 0, i);
		}
	}

}
