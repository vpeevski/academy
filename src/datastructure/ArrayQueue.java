package datastructure;

import java.util.NoSuchElementException;

public final class ArrayQueue<T> implements Queue<T> {

  private static final int    MIN_SIZE        = 5;

  private SizedCycledQueue<T> innerSizedQueue = new SizedCycledQueue<T>(MIN_SIZE);

  @Override
  public void enqueue(T value) {

    if (innerSizedQueue.isFull()) {
      int doubleSize = innerSizedQueue.size() * 2;
      innerSizedQueue = innerSizedQueue.copy(doubleSize);
    }

    innerSizedQueue.enqueue(value);
  }

  @Override
  public T dequeue() {
    T value = innerSizedQueue.dequeue();

    if (innerSizedQueue.size() > MIN_SIZE && innerSizedQueue.lenght() == innerSizedQueue.size() / 4) {
      int halfSize = innerSizedQueue.size() / 2;
      innerSizedQueue = innerSizedQueue.copy(halfSize);

    }
    return value;
  }

  @Override
  public boolean isEmpty() {
    return innerSizedQueue.isEmpty();
  }

  @Override
  public int lenght() {
    return innerSizedQueue.lenght();
  }

  private static final class SizedCycledQueue<T> implements Queue<T>, LimitedSizeInterface {

    private final int      _size;

    private final Object[] _data;

    private int            _back  = -1;
    private int            _front = -1;

    public SizedCycledQueue(int size) {
      _size = size;
      _data = new Object[_size];
    }

    @Override
    public void enqueue(T value) throws IndexOutOfBoundsException {
      int newBack = (_back + 1) % _size;

      if (isFull()) { throw new IndexOutOfBoundsException(); }

      if (isEmpty()) {
        _front = 0;
      }

      _back = newBack;
      _data[_back] = value;
    }

    @Override
    public T dequeue() throws NoSuchElementException {
      if (isEmpty()) { throw new NoSuchElementException(); }

      int newFront = (_front + 1) % _size;
      if (isLastElement()) {
        newFront = -1;
        _back = -1;
      }

      T oldFront = (T) _data[_front];
      _data[_front] = 0;
      _front = newFront;
      return oldFront;

    }

    private boolean isLastElement() {
      return _front == _back;
    }

    @Override
    public boolean isFull() {
      int newBack = (_back + 1) % _size;
      return newBack == _front;
    }

    @Override
    public boolean isEmpty() {
      return _back == -1 && _front == -1;
    }

    @Override
    public int lenght() {
      if (isEmpty())
        return 0;
      if (isLastElement())
        return 1;
      if (_back > _front)
        return _back - _front + 1;
      if (_front > _back)
        return _size - _front + _back + 1;
      return 0;
    }

    @Override
    public int size() {
      return _size;
    }
    
    public SizedCycledQueue<T> copy (int size) {
      SizedCycledQueue<T> sizedQueueNew = new SizedCycledQueue<T>(size);
      while (!isEmpty()) {
        sizedQueueNew.enqueue(dequeue());
      }

      return sizedQueueNew;
    }
    
  }
  
  

}
