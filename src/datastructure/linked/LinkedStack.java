package datastructure.linked;

import java.util.EmptyStackException;

import datastructure.Stack;

public class LinkedStack<T> implements Stack<T> {

  private Node<T> _topNode = null;

  public void push(T value) {
    Node<T> node = new Node<T>(value);
    if (_topNode != null) {
      node.setNext(_topNode);
    }

    _topNode = node;
  }

  public T pop() throws EmptyStackException {

    if (isEmpty()) { throw new EmptyStackException(); }

    Node<T> topNode = _topNode;
    _topNode = _topNode.next();

    return topNode.getValue();

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
      currentNode = currentNode.next();
      count++;
    }
    return count;
  }

}
