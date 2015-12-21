package util;

public final class RefHolder<T> {
	
	private T _ref;
	
	public RefHolder (T ref) {
		_ref = ref;
	}
	
	public void setRef(T ref) {
		_ref = ref;
	}
	
	public T getRef () {
		return _ref;
	}

}
