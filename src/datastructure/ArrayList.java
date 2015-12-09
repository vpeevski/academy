package datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> extends AbstractList<T> {

  private static final int  MIN_SIZE        = 5;

  private ArrayListSized<T> _innerSizedList = new ArrayListSized<T>(MIN_SIZE);

  @Override
  public boolean isEmpty() {
    return _innerSizedList.isEmpty();
  }

  @Override
  public int lenght() {
    return _innerSizedList.lenght();
  }

  @Override
  public void add(T value) {
    if (_innerSizedList.isFull()) {
      int doubleSize = _innerSizedList.size() * 2;
      _innerSizedList = _innerSizedList.copy(doubleSize);
    }

    _innerSizedList.add(value);
  }

  @Override
  public void add(int index, T value) {
    if (_innerSizedList.isFull()) {
      int doubleSize = _innerSizedList.size() * 2;
      _innerSizedList = _innerSizedList.copy(doubleSize);
    }

    _innerSizedList.add(index, value);

  }

  @Override
  public T set(int index, T value) {
    return _innerSizedList.set(index, value);
  }

  @Override
  public T get(int index) {
    return _innerSizedList.get(index);
  }

  @Override
  public Iterator<T> iterator() {
    return _innerSizedList.iterator();
  }

  @Override
  public T remove(int index) {
    return _innerSizedList.remove(index);
  }

  @Override
  public boolean remove(T value) {
    return _innerSizedList.remove(value);
  }

  private static class ArrayListSized<T> implements List<T>, LimitedSizeInterface {

    private final Object[] _data;

    private int            _lastIndex = -1;

    public ArrayListSized(int size) {
      _data = new Object[size];
    }

    @Override
    public boolean isEmpty() {
      return _lastIndex == -1;
    }

    @Override
    public int lenght() {
      return _lastIndex + 1;
    }

    @Override
    public boolean isFull() {
      return lenght() == size();
    }

    @Override
    public int size() {
      return _data.length;
    }

    @Override
    public void add(T value) throws IndexOutOfBoundsException {
      checkSize();
      _lastIndex++;
      _data[_lastIndex] = value;
    }

    @Override
    public T set(int index, T value) throws IndexOutOfBoundsException {
      checkNotEmpty();
      checkIndex(index);

      T oldValue = (T) _data[index];
      _data[index] = value;
      return oldValue;
    }

    @Override
    public T get(int index) {
      checkNotEmpty();
      checkIndex(index);
      return (T) _data[index];
    }

    private void checkIndex(int index) {
      if (0 > index || index > lenght()) { throw new IndexOutOfBoundsException("Index: " + index + " is out of range for List of lenght: " + lenght()); }
    }

    private ArrayListSized<T> copy(int size) {
      ArrayListSized<T> sizedListCopy = new ArrayListSized<T>(size);
      for (int i = 0; i < lenght(); i++) {
        sizedListCopy.add((get(i)));
      }

      return sizedListCopy;
    }

    @Override
    public void add(int index, T value) {
      checkIndex(index);
      checkSize();

      if (index <= _lastIndex) {
        shift(index);
      }

      _data[index] = value;
      _lastIndex++;
    }

    private void shift(int startIndex) {
      System.arraycopy(_data, startIndex, _data, startIndex + 1, lenght() - startIndex);
    }

    private void checkSize() {
      if (isFull()) { throw new IndexOutOfBoundsException(); }
    }

    private void checkNotEmpty() {
      if (isEmpty()) { throw new IndexOutOfBoundsException(); }
    }
    
    @Override
    public T remove(int index) {
      return null; // TODO implement this method
    }

    @Override
    public boolean remove(T value) {
      return false; // TODO implement this method
    }

    @Override
    public Iterator<T> iterator() {
      return new ArrayListIterator();
    }

    private class ArrayListIterator<T> implements Iterator<T> {

      private int _currentIndex;
      private int _lastReturned;

      public ArrayListIterator() {
        _currentIndex = -1;
      }

      @Override
      public boolean hasNext() {
        return _currentIndex + 1 < _lastIndex;
      }

      @Override
      public T next() {
        if (!hasNext()) { throw new NoSuchElementException("List collection do not have next element"); }
        _lastReturned = ++_currentIndex;
        return (T) _data[_lastReturned];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException("Can not remove from List");

      }

    }

  }

}
