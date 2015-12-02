package datastructure.linked;

public final class Node<T> {

  private final T _value;

  private Node<T> _next;

  public Node(T value) {
    _value = value;
  }

  public T getValue() {
    return _value;
  }

  public Node<T> next() {
    return _next;
  }

  public void setNext(Node<T> _next) {
    this._next = _next;
  }

}
