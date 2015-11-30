package datastructure;

import java.util.NoSuchElementException;

public final class ArrayQueue implements Queue {
  
  private static final int MIN_SIZE = 5;

  private SizedCycledQueue innerSizedQueue = new SizedCycledQueue(MIN_SIZE);

  public void enqueue(int value) {
    
    if (innerSizedQueue.isFull()) {
      int doubleSize = innerSizedQueue._size * 2;
      SizedCycledQueue innerSizedQueueNew = new SizedCycledQueue(doubleSize);
      transferQueue(innerSizedQueue, innerSizedQueueNew);
    }
    
    innerSizedQueue.enqueue(value);
  }

  public int dequeue() {
    int value = innerSizedQueue.dequeue();
    
    if (innerSizedQueue._size > MIN_SIZE && innerSizedQueue.lenght() == innerSizedQueue._size / 4) {
      int halfSize = innerSizedQueue._size / 2;
      SizedCycledQueue innerSizedQueueNew = new SizedCycledQueue(halfSize);
      transferQueue(innerSizedQueue, innerSizedQueueNew);

    }
    return value;
  }
  
  private void transferQueue (SizedCycledQueue q1, SizedCycledQueue q2) {
    while (!q1.isEmpty()) {
      q2.enqueue(q1.dequeue());
    }
    
    innerSizedQueue = q2;
  }
  
  public boolean isFull() {
    return innerSizedQueue.isFull();
  }

  public boolean isEmpty() {
    return innerSizedQueue.isEmpty();
  }
  
  public int lenght () {
    return innerSizedQueue.lenght();
  }

  
  
  private static final class SizedCycledQueue implements Queue {

    private final int   _size;

    private final int[] _data;

    private int         _back  = -1;
    private int         _front = -1;

    public SizedCycledQueue(int size) {
      _size = size;
      _data = new int[_size];
    }

    public void enqueue(int value) throws IndexOutOfBoundsException {
      int newBack = (_back + 1) % _size;

      if (isFull()) { throw new IndexOutOfBoundsException(); }

      if (isEmpty()) {
        _front = 0;
      }

      _back = newBack;
      _data[_back] = value;
    }

    public int dequeue() throws NoSuchElementException {
      if (isEmpty()) { throw new NoSuchElementException(); }

      int newFront = (_front + 1) % _size;
      if (isLastElement()) {
        newFront = -1;
        _back = -1;
      }

      int oldFront = _data[_front];
      _data[_front] = 0;
      _front = newFront;
      return oldFront;

    }

    private boolean isLastElement() {
      return _front == _back;
    }

    public boolean isFull() {
      int newBack = (_back + 1) % _size;
      return newBack == _front;
    }

    public boolean isEmpty() {
      return _back == -1 && _front == -1;
    }
    
    public int lenght () {
      if (isEmpty()) return 0;
      if (isLastElement()) return 1;
      if (_back > _front) return _back - _front + 1;
      if (_front > _back) return _size - _front + _back + 1;
      return 0;
    }
  }

}
