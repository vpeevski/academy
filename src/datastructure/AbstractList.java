package datastructure;


public abstract class AbstractList<T> extends AbstractDataStructure<T> implements List <T> {
	
	protected void checkIndex(int index) {
	    if (0 > index || index > lenght()) { throw new IndexOutOfBoundsException("Index: " + index + " is out of range for List of lenght: " + lenght()); }
	}

	protected void checkExistingIndex(int index) {
	    if (isEmpty() || 0 > index || index >= lenght()) { throw new IndexOutOfBoundsException("Index: " + index + " is out of range for List of lenght: " + lenght()); }
	}

}
