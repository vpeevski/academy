package datastructure;

public interface DataStructureInterface <T> extends Iterable<T>{

  boolean isEmpty();
  
  int lenght ();
  
  boolean contains (T value);

}
