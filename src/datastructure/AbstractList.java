package datastructure;


public abstract class AbstractList<T> implements List<T> {
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (!this.getClass().isInstance(obj)) {
			return false;
		}
		List<T> that = (List<T>) obj;
		
		if (this.lenght() != that.lenght()) {
			return false;
		}
		
		for(int i = 0, j = 0; i < this.lenght() && j < that.lenght() ; i++, j++) {
			T thisIValue = this.get(i);
			T thatIValue = that.get(i);
			if(!(thisIValue == null ? thatIValue == null : thisIValue.equals(thatIValue))) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int hashCode = 1;
        for (int i = 0; i < this.lenght(); i++) {
        	T t = this.get(i);
            hashCode = 31*hashCode + (t==null ? 0 : t.hashCode());
        }
        return hashCode;
	}
	
}
