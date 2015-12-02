package datastructure.linked;

import java.util.NoSuchElementException;

import datastructure.Queue;

public class LinkedQueue<T> implements Queue<T> {

  private Node<T> _back  = null;
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

    if (_front == null) { throw new NoSuchElementException(); }

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

}
