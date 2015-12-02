package datastructure.linked;

import java.util.NoSuchElementException;

import datastructure.Queue;

public class LinkedQueue<T> implements Queue<T> {

	private Node<T> _back = null;
	private Node<T> _front = null;

	public void enqueue(T value) {
		Node<T> node = new Node<T>(value);
		if (_back != null) {
			_back.setNext(node);
			_back = node;
		} else {
			_back = node;
			_front = node;
		}

	}

	public T dequeue() throws NoSuchElementException {

		if (_front == null) {
			throw new NoSuchElementException();
		}
		
		Node<T> oldFront = _front;
		_front = _front.getNext();
		
		return oldFront.getValue();

	}

	private static class Node<T> {

		private T _value;

		private Node<T> _next;

		public Node(T value) {
			_value = value;
		}

		public T getValue() {
			return _value;
		}

		public Node<T> getNext() {
			return _next;
		}

		public void setNext(Node<T> _next) {
			this._next = _next;
		}

	}

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int lenght() {
    return 0;
  }

}
