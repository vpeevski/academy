package datastructure;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

  private static final int MIN_SIZE = 5;

  private ArrayStackSized<T> _innerSizedStack = new ArrayStackSized<T>(MIN_SIZE);

  @Override
  public boolean isEmpty() {
    return _innerSizedStack.isEmpty();
  }

  @Override
  public int lenght() {
    return _innerSizedStack.lenght();
  }

  @Override
  public void push(T value) {
    if (_innerSizedStack.isFull()) {
      int doubleSize = _innerSizedStack._size * 2;
      ArrayStackSized<T> innerSizedStackNew = new ArrayStackSized<T>(doubleSize);
      transferStack(_innerSizedStack, innerSizedStackNew);
    }

    _innerSizedStack.push(value);
  }

  @Override
  public T pop() throws EmptyStackException {
    T value = _innerSizedStack.pop();

    if (_innerSizedStack._size > MIN_SIZE && _innerSizedStack.lenght() == _innerSizedStack._size / 4) {
      int halfSize = _innerSizedStack._size / 2;
      ArrayStackSized<T> innerSizedStackNew = new ArrayStackSized<T>(halfSize);
      transferStack(_innerSizedStack, innerSizedStackNew);

    }
    return value;
  }

  private void transferStack(ArrayStackSized<T> s1, ArrayStackSized<T> s2) {
    Queue<T> helpQueue = new ArrayQueue<T>();
    while (!s1.isEmpty()) {
      helpQueue.enqueue(s1.pop());
    }

    while (!helpQueue.isEmpty()) {
      s2.push(helpQueue.dequeue());
    }

    _innerSizedStack = s2;
  }

  private static class ArrayStackSized<T> implements Stack<T>, LimitedSizeInterface {

    private final int      _size;

    private final Object[] _data;

    private int            topIndex = -1;

    public ArrayStackSized(int size) {
      _size = size;
      _data = new Object[_size];
    }

    @Override
    public void push(T value) {
      if (!isFull()) {
        topIndex++;
        _data[topIndex] = value;
      }
    }

    @Override
    public T pop() throws EmptyStackException {
      if (topIndex >= 0) {
        int oldTopIndex = topIndex;
        topIndex--;
        return (T) _data[oldTopIndex];
      } else {
        throw new EmptyStackException();
      }
    }

    @Override
    public boolean isFull() {
      return topIndex == _size - 1;
    }

    @Override
    public boolean isEmpty() {
      return topIndex == -1;
    }

    @Override
    public int lenght() {
      return topIndex + 1;
    }

  }

}
