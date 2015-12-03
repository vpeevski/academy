package datastructure;

public class ArrayList<T> implements List<T>, LimitedSizeInterface {

    private final Object[] _data;
    
    private int _first;
    
    private int _last;
    
    public ArrayList (int size) {
    	_data = new Object[size];
    }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int lenght() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return _data.length;
	}

	@Override
	public void add(T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int index, T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
