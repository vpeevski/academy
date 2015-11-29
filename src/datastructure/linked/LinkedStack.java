package datastructure.linked;

import java.util.EmptyStackException;

public class LinkedStack {

	private Node _topNode = null;

	public void push(int value) {
		Node node = new Node(value);
		if (_topNode != null) {
			node.setPrevious(_topNode);
		}

		_topNode = node;
	}

	public int pop() throws EmptyStackException {

		if (_topNode == null) {
			throw new EmptyStackException();
		}

		Node topNode = _topNode;
		_topNode = _topNode.getPrevious();

		return topNode.getValue();

	}

	private static class Node {

		private int _value;

		private Node _prev;

		public Node(int value) {
			_value = value;
		}

		public int getValue() {
			return _value;
		}

		public void setPrevious(Node prev) {
			_prev = prev;
		}

		public Node getPrevious() {
			return _prev;
		}

	}

}
