package util;

public final class HeapUtil {
	
	private HeapUtil () {};  
	
	public static <T extends Comparable<T>> void buildMaxHeap(T[] arr )
	{
		for( int i = arr.length / 2; i >= 0; i-- )
	        maxHeapify( arr, i, arr.length);
	}
	
	public static <T extends Comparable<T>> void maxHeapify( T[] heapData, int rootIndex, int effectiveLenght)
	{
	    int leftChildIndex = 2 * rootIndex + 1;
	    int rightChildIndex = 2 * rootIndex + 2;
	    int largest = rootIndex;

	    if( leftChildIndex < effectiveLenght && heapData[ leftChildIndex ].compareTo(heapData[ largest ]) >  0)
	        largest = leftChildIndex;
	    if( rightChildIndex < effectiveLenght && heapData[ rightChildIndex ].compareTo(heapData[largest]) > 0 )
	        largest = rightChildIndex;
	    if( largest != rootIndex )
	    {
	        SwapUtil.swap(heapData, rootIndex, largest);
	        maxHeapify(heapData, largest, effectiveLenght);
	    }
	}
	
	public static <T extends Comparable<T>> void buildMinHeap(T[] arr )
	{
		for( int i = arr.length / 2; i >= 0; i-- )
	        minHeapify(arr, i, arr.length);
	}
	
	public static <T extends Comparable<T>> void minHeapify(T[] heapData, int rootIndex, int effectiveLenght)
	{
	    int leftChildIndex = 2 * rootIndex + 1;
	    int rightChildIndex = 2 * rootIndex + 2;
	    int minimal = rootIndex;

	    if( leftChildIndex < effectiveLenght && heapData[ leftChildIndex ].compareTo(heapData[ minimal ]) <  0)
	        minimal = leftChildIndex;
	    if( rightChildIndex < effectiveLenght && heapData[ rightChildIndex ].compareTo(heapData[minimal]) < 0 )
	        minimal = rightChildIndex;
	    if( minimal != rootIndex )
	    {
	        SwapUtil.swap(heapData, rootIndex, minimal);
	        minHeapify(heapData, minimal, effectiveLenght);
	    }
	}
	
	

}
