package datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> extends AbstractList<T> implements List<T> {

  private static final int  MIN_SIZE = 20;

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

  private static class ArrayListSized<T> extends AbstractList<T> implements LimitedSizeInterface {

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
      checkExistingIndex(index);

      T oldValue = (T) _data[index];
      _data[index] = value;
      return oldValue;
    }

    @Override
    public T get(int index) {
      checkExistingIndex(index);
      return (T) _data[index];
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

    private void shiftBack(int startIndex) {
      System.arraycopy(_data, startIndex + 1, _data, startIndex, lenght() - startIndex - 1);
    }

    private void checkSize() {
      if (isFull()) { throw new IndexOutOfBoundsException(); }
    }

    @Override
    public T remove(int index) {
      checkExistingIndex(index);
      T removedElement = (T) _data[index];
      shiftBack(index);
      _data[_lastIndex--] = null;
      return removedElement;
    }

    @Override
    public boolean remove(T value) {
      for (int i = 0; i < lenght(); i++) {
        T currentElem = (T) _data[i];
        if (currentElem == null ? value == null : currentElem.equals(value)) {
          shiftBack(i);
          _data[_lastIndex--] = null;
          return true;
        }
      }
      return false;
    }

    @Override
    public Iterator<T> iterator() {
      return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {

      private int _currentIndex;
      private int _lastReturned;

      public ArrayListIterator() {
        _currentIndex = -1;
        _lastReturned = -1;
      }

      @Override
      public boolean hasNext() {
        return _currentIndex < _lastIndex;
      }

      @Override
      public T next() {
        if (!hasNext()) { throw new NoSuchElementException("List collection do not have next element"); }
        _lastReturned = ++_currentIndex;
        return (T) _data[_lastReturned];
      }

      @Override
      public void remove() {
        if (_lastReturned == -1) { throw new IllegalStateException("Trying to remove from iterator without current element - call next() method before Iterator.remove()"); }
        //TODO check for co-modification and throw ConcurentMofificationException to guarantee fail-fast behavior
        
        ArrayListSized.this.remove(_lastReturned);
        _lastReturned = -1;

      }

    }

  }

}
