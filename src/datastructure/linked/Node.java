package datastructure.linked;

public class Node {
	
	private int _value;
	
	private Node _prev;
	
	public Node (int value) {
		_value = value;
	}

	public int getValue() {
		return _value;
	}
	
	public void setPrevious (Node prev) {
		_prev = prev;
	}
	
	public Node getPrevious () {
		return _prev;
	}
	
	

}
