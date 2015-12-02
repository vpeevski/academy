package datastructure;

import java.util.EmptyStackException;

public interface Stack<T> extends DataStructureInterface<T> {
  
  public void push(T value) throws StackOverflowError;
  
  public T pop() throws EmptyStackException;

}
