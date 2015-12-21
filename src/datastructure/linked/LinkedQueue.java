package datastructure.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

import datastructure.AbstractDataStructure;
import datastructure.Queue;

public class LinkedQueue<T> extends AbstractDataStructure<T> implements Queue<T> {

  private Node<T> _back  = null;
  private Node<T> _front = null;

  public void enqueue(T value) {
    Node<T> node = new Node<T>(value);
    if (!isEmpty()) {
      _back.setNext(node);
      _back = node;
    } else {
      _back = node;
      _front = node;
    }

  }

  public T dequeue() throws NoSuchElementException {

    if (isEmpty()) { throw new NoSuchElementException(); }

    Node<T> oldFront = _front;
    _front = _front.next();

    return oldFront.getValue();

  }

  @Override
  public boolean isEmpty() {
    return _front == null;
  }

  @Override
  public int lenght() {
    Node<T> currentFront = _front;
    int count = 0;
    while (currentFront != null) {
      currentFront = currentFront.next();
      count++;
    }
    return count;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedQueueIterator();
  }
  
  private class LinkedQueueIterator implements Iterator<T> {

    private Node<T> _currentNode;

    public LinkedQueueIterator() {
      _currentNode = _front;
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
      throw new IllegalStateException("Trying to remove from iterator is Forbidden for Queue Object");
    }

  }

}
