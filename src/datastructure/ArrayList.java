package datastructure;

public class ArrayList<T> implements List<T> {

	private static final int MIN_SIZE = 5;

	private ArrayListSized<T> _innerSizedList = new ArrayListSized<T>(MIN_SIZE);

	@Override
	public boolean isEmpty() {
		return _innerSizedList.isEmpty();
	}

	@Override
	public int lenght() {
		return _innerSizedList.lenght();
	}

	@Override
	public void add(T value) {
		if (_innerSizedList.isFull()) {
			int doubleSize = _innerSizedList.size() * 2;
			_innerSizedList = _innerSizedList.copy(doubleSize);
		}

		_innerSizedList.add(value);
	}

	@Override
	public void add(int index, T value) {
		if (_innerSizedList.isFull()) {
			int doubleSize = _innerSizedList.size() * 2;
			_innerSizedList = _innerSizedList.copy(doubleSize);
		}

		_innerSizedList.add(index, value);

	}

	@Override
	public T set(int index, T value) {
		return _innerSizedList.set(index, value);
	}

	@Override
	public T get(int index) {
		return _innerSizedList.get(index);
	}

	private static class ArrayListSized<T> implements List<T>,
			LimitedSizeInterface {

		private final Object[] _data;

		private int _lastIndex = -1;

		public ArrayListSized(int size) {
			_data = new Object[size];
		}

		@Override
		public boolean isEmpty() {
			return _lastIndex == -1;
		}

		@Override
		public int lenght() {
			return _lastIndex + 1;
		}

		@Override
		public boolean isFull() {
			return lenght() == size();
		}

		@Override
		public int size() {
			return _data.length;
		}

		@Override
		public void add(T value) throws IndexOutOfBoundsException {
			checkSize();
			_lastIndex++;
			_data[_lastIndex] = value;
		}

		@Override
		public T set(int index, T value) throws IndexOutOfBoundsException {
			checkNotEmpty();
			checkIndex(index);

			T oldValue = (T) _data[index];
			_data[index] = value;
			return oldValue;
		}

		@Override
		public T get(int index) {
			checkNotEmpty();
			checkIndex(index);
			return (T) _data[index];
		}

		private void checkIndex(int index) {
			if (0 > index || index > lenght()) {
				throw new IndexOutOfBoundsException("Index: " + index
						+ " is out of range for List of lenght: " + lenght());
			}
		}

		private ArrayListSized<T> copy(int size) {
			ArrayListSized<T> sizedListCopy = new ArrayListSized<T>(size);
			for (int i = 0; i < lenght(); i++) {
				sizedListCopy.add((get(i)));
			}

			return sizedListCopy;
		}

		@Override
		public void add(int index, T value) {
			checkIndex(index);
			checkSize();
			
			if (index <= _lastIndex) {
				shift(index);
			}
			
			_data[index] = value;
			_lastIndex++;
		}

		private void shift(int startIndex) {
			System.arraycopy(_data, startIndex, _data, startIndex + 1, 1);
		}

		private void checkSize() {
			if (isFull()) {
				throw new IndexOutOfBoundsException();
			}
		}
		
		private void checkNotEmpty() {
			if (isEmpty()) {
				throw new IndexOutOfBoundsException();
			}
		}

	}

}
