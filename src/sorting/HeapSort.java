package sorting;

public class HeapSort extends AbstractSortWithTimer {

	@Override
	public void sort(int[] inputArray) {
		heapSort(inputArray);

	}

	private void heapSort(int numbers[]) {
		buildMaxHeap(numbers, numbers.length);
		
		for (int i = numbers.length - 1; i >= 0; i--) {
			swap(numbers, 0, i);
			buildMaxHeap(numbers, i);
			//maxHeapify(numbers, i / 2 , i);
		}
	}
	
	public void buildMaxHeap(int[] arr, int lenght )
	{
		for( int i = lenght / 2; i >= 0; i-- )
	        maxHeapify( arr, i, lenght);
	}
	public void maxHeapify( int[ ] arr, int rootIndex, int effectiveLenght )
	{
	    int leftChildIndex = 2 * rootIndex + 1;
	    int rightChildIndex = 2 * rootIndex + 2;
	    int largest = rootIndex;

	    if( leftChildIndex < effectiveLenght && arr[ leftChildIndex ] > arr[ largest ] )
	        largest = leftChildIndex;
	    if( rightChildIndex < effectiveLenght && arr[ rightChildIndex ] > arr[ largest ] )
	        largest = rightChildIndex;
	    if( largest != rootIndex )
	    {
	        swap(arr, rootIndex, largest);
	        maxHeapify(arr, largest, effectiveLenght);
	    }
	}

}
