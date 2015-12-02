package datastructure.linked;

import java.util.EmptyStackException;

import datastructure.Stack;

public class LinkedStack<T> implements Stack<T> {

	private Node<T> _topNode = null;

	public void push(T value) {
		Node<T> node = new Node<T>(value);
		if (_topNode != null) {
			node.setPrevious(_topNode);
		}

		_topNode = node;
	}

	public T pop() throws EmptyStackException {

		if (isEmpty()) {
			throw new EmptyStackException();
		}

		Node<T> topNode = _topNode;
		_topNode = _topNode.getPrevious();

		return topNode.getValue();

	}

	private static class Node<T> {

		private T _value;

		private Node<T> _prev;

		public Node(T value) {
			_value = value;
		}

		public T getValue() {
			return _value;
		}

		public void setPrevious(Node<T> prev) {
			_prev = prev;
		}

		public Node<T> getPrevious() {
			return _prev;
		}

	}
	

  @Override
  public boolean isEmpty() {
    return _topNode == null;
  }

  @Override
  public int lenght() {
    Node<T> currentNode = _topNode;
    int count = 0;
    while (currentNode != null) {
      currentNode.getPrevious();
      count++;
    }
    return count;
  }

}
