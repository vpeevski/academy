package datastructure;

public interface Heap<T extends Comparable<T>> extends DataStructureInterface<T> {
	
	T pull();
	
	void insert(T value);

}
