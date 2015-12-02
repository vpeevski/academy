package datastructure;

import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {

  private static final int   MIN_SIZE         = 5;

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
      int doubleSize = _innerSizedStack.size() * 2;
      _innerSizedStack = _innerSizedStack.copy(doubleSize);
    }

    _innerSizedStack.push(value);
  }

  @Override
  public T pop() throws EmptyStackException {
    T value = _innerSizedStack.pop();

    if (_innerSizedStack.size() > MIN_SIZE && _innerSizedStack.lenght() == _innerSizedStack.size() / 4) {
      int halfSize = _innerSizedStack.size() / 2;
      _innerSizedStack = _innerSizedStack.copy(halfSize);

    }
    return value;
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

    @Override
    public int size() {
      return _size;
    }

    public ArrayStackSized<T> copy (int size) {
      ArrayStackSized<T> sizedStackNew = new ArrayStackSized<T>(size);
      Stack<T> helpStack = new ArrayStack<T>();
      while (!isEmpty()) {
        helpStack.push(pop());
      }

      while (!helpStack.isEmpty()) {
        sizedStackNew.push(helpStack.pop());
      }

      return sizedStackNew;
    }

  }

}
