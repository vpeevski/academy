package datastructure;

public class ArrayList<T> implements List<T>, LimitedSizeInterface {

    private final Object[] _data;
    
    private int _lastIndex = -1;
    
    public ArrayList (int size) {
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
		return _lastIndex == _data.length  - 1;
	}

	@Override
	public int size() {
		return _data.length;
	}

	@Override
	public void add(T value) throws IndexOutOfBoundsException {
		if(isFull()) {throw new IndexOutOfBoundsException();}
		_lastIndex++;
		_data[_lastIndex] = value;
	}

	@Override
	public void add(int index, T value) throws IndexOutOfBoundsException {
		checkIndex(index);
		
	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return (T) _data[index];
	}
	
	private void checkIndex(int index) {
		if (0 > index || index > lenght()) {
			throw new IndexOutOfBoundsException("Index: " + index
					+ " is out of range for List of lenght: " + lenght());
		}
	}

	
}
