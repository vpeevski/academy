package datastructure;

public interface Heap<T extends Comparable<T>> {
	
	T pull();
	
	void insert(T value);

}
