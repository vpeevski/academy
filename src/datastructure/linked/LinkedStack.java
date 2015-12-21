package datastructure.linked;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import datastructure.AbstractDataStructure;
import datastructure.Stack;

public class LinkedStack<T> extends AbstractDataStructure<T> implements Stack<T> {

  private Node<T> _topNode = null;

  public void push(T value) {
    Node<T> node = new Node<T>(value);
    
    if (!isEmpty()) {
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

  @Override
  public Iterator<T> iterator() {
    return new LinkedStackIterator();
  }
  
  private class LinkedStackIterator implements Iterator<T> {

    private Node<T> _currentNode;

    public LinkedStackIterator() {
      _currentNode = _topNode;
    }

    @Override
    public boolean hasNext() {
      return _currentNode != null;
    }

    @Override
    public T next() {
      if (!hasNext()) { throw new NoSuchElementException("List collection do not have next element"); }
      T currentValue = _currentNode.getValue();
      _currentNode = _currentNode.next();
      return currentValue; // TODO clone here
    }

    @Override
    public void remove() {
      throw new IllegalStateException("Trying to remove from iterator is Forbidden for Stack Object");
    }

  }

}
