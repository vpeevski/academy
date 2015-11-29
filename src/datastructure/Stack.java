package datastructure;

import java.util.EmptyStackException;


public class Stack {
	
	private final int _size;
	
	private final int[] _data;
	
	private int topIndex = -1;
	
	public Stack (int size) {
		_size = size;
		_data = new int[_size];
	}
	
	
	
	public void push (int value) throws StackOverflowError {
		if (topIndex < _size - 1) {
			topIndex++;
			_data[topIndex] = value;
		} else {
			throw new StackOverflowError();
		}
	}
	
	public int pop () throws EmptyStackException {
		if (topIndex >= 0) {
			int oldTopIndex = topIndex;
			topIndex--;
			return _data[oldTopIndex];
		} else {
			throw new EmptyStackException();
		}
	}

}
