package datastructure;

public interface Queue<T> extends DataStructureInterface<T> {
  
  void enqueue(T value);
  
  T dequeue ();

}
