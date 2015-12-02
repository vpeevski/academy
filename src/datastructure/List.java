package datastructure;

public interface List<T> extends DataStructureInterface<T> {
  
  void add (T value);
  
  void add (int index, T value);
  
  T get (int index);

}
