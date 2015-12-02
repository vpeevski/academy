package datastructure;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

	private final int _size;

	private final Object[] _data;

	private int topIndex = -1;

	public ArrayStack(int size) {
		_size = size;
		_data = new Object[_size];
	}

	public void push(T value) throws StackOverflowError {
		if (topIndex < _size - 1) {
			topIndex++;
			_data[topIndex] = value;
		} else {
			throw new StackOverflowError();
		}
	}

	public T pop() throws EmptyStackException {
		if (topIndex >= 0) {
			int oldTopIndex = topIndex;
			topIndex--;
			return (T) _data[oldTopIndex];
		} else {
			throw new EmptyStackException();
		}
	}

  @Override
  public boolean isFull() {
    return topIndex == _size - 1;
  }

  @Override
  public boolean isEmpty() {
    return topIndex == -1;
  }

  @Override
  public int lenght() {
    return topIndex + 1;
  }

}
