package datastructure;

import java.util.Iterator;

public final class PriorityQueue<T extends Comparable<T>> extends AbstractDataStructure<T> implements Queue<T>  {
  
  private final Heap<T> heap = new ArrayHeap<T>();

  @Override
  public boolean isEmpty() {
    return heap.isEmpty();
  }

  @Override
  public int lenght() {
    return heap.lenght();
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public void enqueue(T value) {
    heap.insert(value);
  }

  @Override
  public T dequeue() {
    return heap.pull();
  }

}
