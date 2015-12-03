package datastructure.linked;

import datastructure.List;

public class LinkedList<T> implements List<T> {

	private Node<T> _fisrt;

	private Node<T> _last;

	private int _lenght;

	@Override
	public boolean isEmpty() {
		return _fisrt == null;
	}

	@Override
	public int lenght() {
		return _lenght;
	}

	@Override
	public void add(T value) {
		linkLast(value);
	}

	@Override
	public void add(int index, T value) {
		checkIndex(index);

		if (index == _lenght) {
			linkLast(value);
		} else {
			linkBefore(value, node(index));
		}

	}

	private void checkIndex(int index) {
		if (0 > index || index > lenght()) {
			throw new IndexOutOfBoundsException("Index: " + index
					+ " is out of range for List of lenght: " + lenght());
		}
	}

	private Node<T> node(int index) {
		Node<T> result = _fisrt;
		for (int i = 0; i < index; i++) {
			result = result.next;
		}

		return result;
	}

	private void linkBefore(T value, Node<T> nextNode) {
		Node<T> tempPrevNode = nextNode.prev;
		Node<T> newNode = new Node<T>(tempPrevNode, value, nextNode);
		nextNode.prev = newNode;
		if (tempPrevNode == null) {
			_fisrt = newNode;
		} else {
			tempPrevNode.next = newNode;
		}

		_lenght++;

	}

	private void linkLast(T value) {
		Node<T> tempLastNode = _last;
		Node<T> newNode = new Node<T>(tempLastNode, value, null);
		_last = newNode;
		if (tempLastNode == null) {
			_fisrt = newNode;
		} else {
			tempLastNode.next = newNode;
		}

		_lenght++;

	}

	@Override
	public T get(int index) {
		checkIndex(index);
		return node(index).value;
	}

	private static class Node<E> {
		E value;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.value = element;
			this.next = next;
			this.prev = prev;
		}
	}

}
