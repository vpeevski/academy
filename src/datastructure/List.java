package datastructure;

public interface List<T> extends DataStructureInterface<T>, Iterable <T> {
  
  void add (T value);
  
  void add (int index, T value);
  
  T set (int index, T value);
  
  T get (int index);
  
  T remove(int index);
  
  boolean remove(T value);

}
