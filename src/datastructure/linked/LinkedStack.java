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

}
