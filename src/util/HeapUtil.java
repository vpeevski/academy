package util;

public final class HeapUtil {
	
	private HeapUtil () {};  
	
	public static <T extends Comparable<T>> void buildMaxHeap(T[] arr )
	{
		for( int i = arr.length / 2; i >= 0; i-- )
	        maxHeapifyRoot( arr, i, arr.length);
	}
	
//	public static <T extends Comparable<T>> void maxHeapifyRoot( T[] heapData, int rootIndex, int effectiveLenght) {
//	    int leftChildIndex = 2 * rootIndex + 1;
//	    int rightChildIndex = 2 * rootIndex + 2;
//	    int largest = rootIndex;
//
//	    if( leftChildIndex < effectiveLenght && heapData[ leftChildIndex ].compareTo(heapData[ largest ]) >  0)
//	        largest = leftChildIndex;
//	    if( rightChildIndex < effectiveLenght && heapData[ rightChildIndex ].compareTo(heapData[largest]) > 0 )
//	        largest = rightChildIndex;
//	    if( largest != rootIndex )
//	    {
//	        SwapUtil.swap(heapData, rootIndex, largest);
//	        maxHeapifyRoot(heapData, largest, effectiveLenght);
//	    }
//	}
	
	public static <T extends Comparable<T>> void maxHeapifyRoot( T[] heapData, int rootIndex, int effectiveLenght) {
//	    int leftChildIndex = 2 * rootIndex + 1;
//	    int rightChildIndex = 2 * rootIndex + 2;
	    int largest = rootIndex;
	    int maxChildIndex = findMaxChild(heapData, rootIndex, effectiveLenght);
	    
	    if(heapData[maxChildIndex].compareTo(heapData[largest]) > 0) {
	    	largest = maxChildIndex;
	    }
	    
	    if( largest != rootIndex )
	    {
	        SwapUtil.swap(heapData, rootIndex, largest);
	        if (largest < heapData.length / 2) {
	        	maxHeapifyRoot(heapData, largest, effectiveLenght);
	        }
	        
	    }
	}
	
	private static <T extends Comparable<T>>  int findMaxChild(T[] heapData, int rootIndex, int effectiveLenght) {
		int maxChildIndex = rootIndex;
		int leftChildIndex = 2*rootIndex + 1;
		int rigntChildIndex = 2*rootIndex + 2;
		if (leftChildIndex < effectiveLenght && rigntChildIndex < effectiveLenght) {
			if (heapData[leftChildIndex].compareTo(heapData[rigntChildIndex]) >= 0) {
				maxChildIndex = leftChildIndex;
			} else {
				maxChildIndex = rigntChildIndex;
			}
		} else if(leftChildIndex < effectiveLenght){
			maxChildIndex = leftChildIndex;
		}
		
		
		return maxChildIndex;
	}

	public static <T extends Comparable<T>> void maxHeapifyLastLeaf( T[] heapData, int leafIndex) {
	    if (leafIndex == 0) {
	      return;
	    }
	    
	    int rootIndex = (leafIndex - 1) / 2;

        if( heapData[leafIndex].compareTo(heapData[rootIndex]) >  0) {
            SwapUtil.swap(heapData, rootIndex, leafIndex);
            maxHeapifyLastLeaf(heapData, rootIndex);
        }
        
    }
	
	public static <T extends Comparable<T>> void minHeapifyLastLeaf( T[] heapData, int leafIndex) {
      if (leafIndex == 0) {
        return;
      }
      
      int rootIndex = (leafIndex - 1) / 2;

      if( heapData[leafIndex].compareTo(heapData[rootIndex]) <  0) {
          SwapUtil.swap(heapData, rootIndex, leafIndex);
          minHeapifyLastLeaf(heapData, rootIndex);
      }
      
  }
	
	public static <T extends Comparable<T>> void buildMinHeap(T[] arr ) {
		for( int i = arr.length / 2; i >= 0; i-- )
	        minHeapifyRoot(arr, i, arr.length);
	}
	
	public static <T extends Comparable<T>> void minHeapifyRoot(T[] heapData, int rootIndex, int effectiveLenght) {
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
	        if (minimal < heapData.length / 2) {
	        	minHeapifyRoot(heapData, minimal, effectiveLenght);
	        }
	    }
	}
	
	

}
