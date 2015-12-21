package sorting;

public abstract class AbstractSort {
  
  public abstract <T extends Comparable<T>> void sort (T[] inputArray);

}
