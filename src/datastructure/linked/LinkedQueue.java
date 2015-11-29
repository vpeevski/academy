package datastructure.linked;

import java.util.NoSuchElementException;

public class LinkedQueue {

	private Node _back = null;
	private Node _front = null;

	public void enqueue(int value) {
		Node node = new Node(value);
		if (_back != null) {
			node.setPrev(_back);
			_back.setNext(node);
			_back = node;
		} else {
			_back = node;
			_front = node;
		}

	}

	public int dequeue() throws NoSuchElementException {

		if (_front == null) {
			throw new NoSuchElementException();
		}
		
		Node oldFront = _front;
		_front = _front.getNext();
		
		return oldFront.getValue();

	}

	private static class Node {

		private int _value;

		private Node _next;

		private Node _prev;

		public Node(int value) {
			_value = value;
		}

		public int getValue() {
			return _value;
		}

		public Node getNext() {
			return _next;
		}

		public void setNext(Node _next) {
			this._next = _next;
		}

		public Node getPrev() {
			return _prev;
		}

		public void setPrev(Node _prev) {
			this._prev = _prev;
		}

	}

}
