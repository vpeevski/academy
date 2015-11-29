package datastructure;

import java.util.NoSuchElementException;

public class Queue {

	private final int _size;

	private final int[] _data;

	private int _back = -1;
	private int _front = -1;

	public Queue(int size) {
		_size = size;
		_data = new int[_size];
	}

	public void enqueue(int value) throws IndexOutOfBoundsException {
		int newBack = (_back + 1) % _size;
		
		if(newBack == _front) {
			throw new IndexOutOfBoundsException();
		}
		
		if (_back == -1 && _front == -1) {
			_front = 0;
		}
		
		_back = newBack;
		_data[_back] = value;
	}

	public int dequeue() throws NoSuchElementException {
		int newFront = (_front + 1) % _size;
		int newBack = _back;
		if(_front == _back) {
			newFront = -1;
			newBack = -1;
		}
		
		 
		if (_front > -1) {
			int oldFront = _data[_front];
			_front = newFront;
			_back = newBack;
			return oldFront;
		} else {
			throw new NoSuchElementException();
		}
	}

}
