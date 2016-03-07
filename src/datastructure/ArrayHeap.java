package datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

import util.HeapUtil;

public class ArrayHeap<T extends Comparable<T>> extends
		AbstractDataStructure<T> implements Heap<T> {
  
    public static final int HEAP_TYPE_MAX = 1;
    public static final int HEAP_TYPE_MIN = 2;
	
	private static final int    MIN_SIZE        = 5;

	private SizedArrayHeap<T> _innerSizedArrayHeap = new SizedArrayHeap<T>(MIN_SIZE);
	
	public ArrayHeap() {
      _innerSizedArrayHeap = new SizedArrayHeap<T>(MIN_SIZE, HEAP_TYPE_MAX);
    }
	
	public ArrayHeap(final int heapType) {
	  _innerSizedArrayHeap = new SizedArrayHeap<T>(MIN_SIZE, heapType);
	}
	
	public ArrayHeap(T[] arr, int heapType) {
	  _innerSizedArrayHeap = new SizedArrayHeap<T>(arr, heapType);
	}
	
	public ArrayHeap(T[] arr) {
      _innerSizedArrayHeap = new SizedArrayHeap<T>(arr, HEAP_TYPE_MAX);
    }
	
	@Override
	public T pull() {
	  
	    T value = _innerSizedArrayHeap.pull();

	    if (_innerSizedArrayHeap.lenght() > MIN_SIZE && _innerSizedArrayHeap.lenght() == _innerSizedArrayHeap.size() / 4) {
	      int halfSize = _innerSizedArrayHeap.size() / 2;
	      _innerSizedArrayHeap.enlarge(halfSize);

	    }
	    return value;
		
	}

	@Override
	public void insert(T value) {
		if (_innerSizedArrayHeap.isFull()) {
		      int doubleSize = _innerSizedArrayHeap.size() * 2;
		      _innerSizedArrayHeap.enlarge(doubleSize);
		    }
		_innerSizedArrayHeap.insert(value);
	}

	@Override
	public boolean isEmpty() {
		return _innerSizedArrayHeap.isEmpty();
	}

	@Override
	public int lenght() {
		return _innerSizedArrayHeap.lenght();
	}

	@Override
	public Iterator<T> iterator() {
		return _innerSizedArrayHeap.iterator();
	}

	public class SizedArrayHeap<T extends Comparable<T>> extends
			AbstractDataStructure<T> implements LimitedSizeInterface, Heap<T> {

		private T[] _heapData;
		private int _heapType = HEAP_TYPE_MAX;

		private int _size;
		private int _lenght;

		@Override
		public void insert(T value) {
			if (isFull()) {
				throw new IndexOutOfBoundsException();
			}
			_lenght++;
			_heapData[_lenght - 1] = value;
			if (_heapType == HEAP_TYPE_MAX) {
				HeapUtil.maxHeapifyLastLeaf(_heapData, _lenght - 1);
			} else if (_heapType == HEAP_TYPE_MIN) {
				HeapUtil.minHeapifyLastLeaf(_heapData, _lenght - 1);
			}
		}

		@Override
		public T pull() {
			if (isEmpty()) {
				throw new NoSuchElementException();
			}
			T rootValue = (T) _heapData[0];
			_heapData[0] = _heapData[_lenght - 1];
			_heapData[_lenght - 1] = null;
			if (_lenght > 1 &&_heapType == HEAP_TYPE_MAX) {
				HeapUtil.maxHeapifyRoot(_heapData, 0, _lenght - 1);
			} else if (_lenght > 1 && _heapType == HEAP_TYPE_MIN) {
				HeapUtil.minHeapifyRoot(_heapData, 0, _lenght - 1);
			}
			_lenght--;
			return rootValue;
		}

		public SizedArrayHeap(int size) { // TODO add test for this method
			this(size, HEAP_TYPE_MAX);
		}

		public SizedArrayHeap(int size, int heapType) {
			_size = size;
			_heapData = (T[]) new Comparable[_size];
			_lenght = 0;
			_heapType = HEAP_TYPE_MAX;
			if (heapType == HEAP_TYPE_MIN) {
				_heapType = heapType;
			}
		}

		public SizedArrayHeap(T[] arr, final int heapType) {

			if (heapType == HEAP_TYPE_MIN) {
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
			return _lenght == _size;
		}

		@Override
		public int size() {
			return _size;
		}

		@Override
		public Iterator<T> iterator() {
			return new ArrayHeapIterator();
		}
		
		private void enlarge(int doubleSize) {
		  Comparable[] sizedListCopy = new Comparable[doubleSize];
	      System.arraycopy(_heapData, 0, sizedListCopy, 0, _heapData.length);
	      _size = doubleSize;
	      _heapData = (T[]) sizedListCopy;
	    }

		private class ArrayHeapIterator implements Iterator<T> {

			private int _currentIndex;

			public ArrayHeapIterator() {
				_currentIndex = -1;
			}

			@Override
			public boolean hasNext() {
				return _currentIndex + 1 < lenght();
			}

			@Override
			public T next() {
				if (!hasNext()) {
					throw new NoSuchElementException(
							"List collection do not have next element");
				}
				return (T) _heapData[++_currentIndex]; // TODO clone here
			}

			@Override
			public void remove() {
				throw new IllegalStateException(
						"Trying to remove from iterator is Forbidden for Heap Object");
			}

		}
	}

}
