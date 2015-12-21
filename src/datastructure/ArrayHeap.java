package datastructure;

import java.util.NoSuchElementException;

import util.HeapUtil;

public class ArrayHeap<T extends Comparable<T>> implements DataStructureInterface<T>, LimitedSizeInterface {
	
	public static final int HEAP_TYPE_MAX = 1;
	public static final int HEAP_TYPE_MIN = 2;
	
	private T[] _heapData;
	private int _heapType = HEAP_TYPE_MAX;
	
	private final int _size;	private int _lenght;
	
	
	public void insert (T value) { //TODO add test for this method
		if (isFull()) { throw new IndexOutOfBoundsException(); }
		_lenght++;
		_heapData[_lenght - 1] = value;
		if(_heapType == HEAP_TYPE_MAX) {
			HeapUtil.maxHeapify(_heapData, 0, _lenght - 1);
		} else if (_heapType == HEAP_TYPE_MIN) {
			HeapUtil.minHeapify(_heapData, 0, _lenght - 1);
		}
	}
	
	public T pull () {
		if (isEmpty()) { throw new NoSuchElementException(); }
		T rootValue = (T) _heapData[0];
		_heapData[0] = _heapData[_lenght - 1];
		_heapData[_lenght - 1] = null;
		if(_heapType == HEAP_TYPE_MAX) {
			HeapUtil.maxHeapify(_heapData, 0, _lenght - 1);
		} else if (_heapType == HEAP_TYPE_MIN) {
			HeapUtil.minHeapify(_heapData, 0, _lenght - 1);
		}
		_lenght--;
		return rootValue;
	}
	
	public ArrayHeap (int size) { //TODO add test for this method
		this(size, HEAP_TYPE_MAX);
	}
	
	public ArrayHeap (int size, int heapType) { //TODO add test for this method
		_size = size;
		_heapData = (T[]) new Object[_size];
		_lenght = 0;
		_heapType = HEAP_TYPE_MAX;
		if(heapType == HEAP_TYPE_MIN) {
			_heapType = heapType;
		}
	}
	
	public ArrayHeap (T[] arr, final int heapType) {
		
		if(heapType == HEAP_TYPE_MIN) {
			_heapType = HEAP_TYPE_MIN;
			HeapUtil.buildMinHeap(arr);
		} else if (heapType == HEAP_TYPE_MAX) {
			_heapType = HEAP_TYPE_MAX;
			HeapUtil.buildMaxHeap(arr);
		} else {
			_heapType = HEAP_TYPE_MAX;
			HeapUtil.buildMaxHeap(arr);
		}
		
		_size = arr.length;
		_lenght = arr.length;
		_heapData = arr.clone();
	}
	

	@Override
	public boolean isEmpty() {
		return _lenght == 0;
	}

	@Override
	public int lenght() {
		return _lenght;
	}

	@Override
	public boolean isFull() {
		return _heapData.length == _size;
	}

	@Override
	public int size() {
		return _size;
	}

}
