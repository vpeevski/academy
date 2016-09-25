package datastructure;

public abstract class AbstractSizedDataStructure<T> extends AbstractDataStructure<T> implements LimitedSizeInterface {
	
	@Override
	public boolean isFull() {
		return lenght() == size();
	}

}
