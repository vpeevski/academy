package datastructure;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> extends AbstractDataStructure<T> implements Stack<T> {

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
  
  @Override
  public Iterator<T> iterator() {
    return _innerSizedStack.iterator();
  }

  private static class ArrayStackSized<T> extends AbstractSizedDataStructure<T> implements Stack<T> {

    private final Object[] _data;

    private int            topIndex = -1;

    public ArrayStackSized(int size) {
      _data = new Object[size];
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
    public boolean isEmpty() {
      return topIndex == -1;
    }

    @Override
    public int lenght() {
      return topIndex + 1;
    }

    @Override
    public int size() {
      return _data.length;
    }

    private ArrayStackSized<T> copy (int size) {
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

    @Override
    public Iterator<T> iterator() {
      return new ArrayStackIterator();
    }
    
    private class ArrayStackIterator implements Iterator<T> {

        private int _currentIndex;
        
        public ArrayStackIterator() {
          _currentIndex = topIndex;
        }

        @Override
        public boolean hasNext() {
          return _currentIndex >= 0;
        }

        @Override
        public T next() {
          if (!hasNext()) { throw new NoSuchElementException("List collection do not have next element"); }
          return (T) _data[_currentIndex--];
        }

        @Override
        public void remove() {
          throw new IllegalStateException("Iterator remove is not allowed for Stack Object");
        }

      }

  }

}
