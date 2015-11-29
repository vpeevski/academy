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

		if (isFull()) {
			throw new IndexOutOfBoundsException();
		}

		if (isEmpty()) {
			_front = 0;
		}

		_back = newBack;
		_data[_back] = value;
	}

	public int dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int newFront = (_front + 1) % _size;
		if (isLastElement()) {
			newFront = -1;
			_back = -1;
		}

		int oldFront = _data[_front];
		_front = newFront;
		return oldFront;

	}

	private boolean isLastElement() {
		return _front == _back;
	}

	public boolean isFull() {
		int newBack = (_back + 1) % _size;
		return newBack == _front;
	}

	public boolean isEmpty() {
		return _back == -1 && _front == -1;
	}

}
