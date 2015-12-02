package datastructure.linked;

import datastructure.List;

public class LinkedList<T> implements List<T> {

  private Node<T> _fisrt;

  private Node<T> _last;

  @Override
  public boolean isEmpty() {
    return _fisrt == null;
  }

  @Override
  public int lenght() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void add(T value) {
    if (isEmpty()) {
      Node<T> newNode = new Node<T>(null, value, null);
      _fisrt = _last = newNode;
    } else {
      Node<T> newNode = new Node<T>(_last, value, null);
      _last = newNode;
    }

  }

  @Override
  public void add(int index, T value) {
    // TODO Auto-generated method stub

  }

  @Override
  public T get(int index) {
    T result = _fisrt.value;
    return null;
  }

  private static class Node<E> {
    E       value;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
      this.value = element;
      this.next = next;
      this.prev = prev;
    }
  }

}
