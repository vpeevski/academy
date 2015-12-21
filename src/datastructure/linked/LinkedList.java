package datastructure.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

import datastructure.AbstractDataStructure;
import datastructure.List;

public class LinkedList<T> extends AbstractDataStructure<T> implements List<T>{

  private Node<T> _fisrt;

  private Node<T> _last;

  private int     _lenght;

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
  public T set(int index, T value) {
    checkExistingIndex(index);

    Node<T> oldNode = node(index);
    T oldValue = oldNode.value;
    oldNode.value = value;

    return oldValue;

  }

  private Node<T> node(int index) {
    Node<T> result = _fisrt; //TODO Optimize this to start from front or end depending on which is nearer
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
    checkExistingIndex(index);
    return node(index).value;
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

  @Override
  public void add(int index, T value) {
    checkIndex(index);

    Node<T> oldNode = node(index);
    if (index == _lenght) {
      linkLast(value);
    } else {
      linkBefore(value, oldNode);
    }

  }

  @Override
  public T remove(int index) {
    checkExistingIndex(index);
    return unlink(node(index));
  }

  private T unlink(Node<T> node) {
    if (node.prev == null) { return unlinkFirst(); }

    if (node.next == null) { return unlinkLast(); }

    node.prev.next = node.next;
    node.next.prev = node.prev;

    T value = node.value;

    node.next = null;
    node.prev = null;
    node.value = null;

    _lenght--;

    return value;
  }

  @Override
  public boolean remove(T value) {
    for (int i = 0; i < _lenght; i++) {
      Node<T> currentNode = node(i);
      if (value == null ? currentNode.value == null : currentNode.value.equals(value)) {
        unlink(currentNode);
        return true;
      }
    }

    return false;

  }

  private T unlinkFirst() {
    Node<T> next = _fisrt.next;
    T value = _fisrt.value;
    _fisrt.value = null;
    _fisrt.next = null;
    _fisrt = next;

    if (next == null) {
      _last = null;
    } else {
      next.prev = null;
    }

    _lenght--;
    return value;
  }

  private T unlinkLast() {
    Node<T> prev = _last.prev;
    T value = _last.value;
    _last.value = null;
    _last.prev = null;
    _last = prev;

    if (prev == null) {
      _fisrt = null;
    } else {
      prev.next = null;
    }

    _lenght--;
    return value;
  }

  @Override
  public Iterator<T> iterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {

    private Node<T> _current;
    private Node<T>       _lastReturned;

    public LinkedListIterator() {
      _current = (Node<T>) _fisrt;
    }

    @Override
    public boolean hasNext() {
      return _current != null;
    }

    @Override
    public T next() {
      if (!hasNext()) { throw new NoSuchElementException("List collection do not have next element"); }
      _lastReturned = _current;
      _current = _current.next;
      return _lastReturned.value;
    }

    @Override
    public void remove() {
      if (_lastReturned == null) {
        throw new IllegalStateException();
      }
      //TODO check for co-modification and throw ConcurentMofificationException to guarantee fail-fast behavior
      
      unlink(_lastReturned);
      _lastReturned = null;
    }

  }

}
