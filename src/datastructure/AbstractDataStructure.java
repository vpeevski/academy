package datastructure;

import java.util.Iterator;

public abstract class AbstractDataStructure<T> implements DataStructureInterface<T> {

  @Override
  public boolean equals(Object obj) {
    if (obj == this) { return true; }

    if (!this.getClass().isInstance(obj)) { return false; }
    AbstractDataStructure<T> that = (AbstractDataStructure<T>) obj;

    if (this.lenght() != that.lenght()) { return false; }

    for (Iterator<T> iteratorThis = iterator(), iteratorThat = that.iterator(); iteratorThis.hasNext() && iteratorThat.hasNext();) {
      T thisIValue = iteratorThis.next();
      T thatIValue = iteratorThat.next();
      if (!(thisIValue == null ? thatIValue == null : thisIValue.equals(thatIValue))) { return false; }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;
    for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
      T t = iterator.next();
      hashCode = 31 * hashCode + (t == null ? 0 : t.hashCode());
    }
    return hashCode;
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    boolean isFirst = true;
    for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
      if(isFirst) {
        isFirst = false;
      } else {
        builder.append(", ");
      }
      builder.append(iterator.next().toString());
    }
    builder.append("]");
    return builder.toString();
  }
  
  @Override
  public boolean contains(T value) {
	  for (Iterator<T> iterator = iterator(); iterator.hasNext();) {
	      T t = iterator.next();
	      if (t == null ? value == null : t.equals(value)) {
	    	  return true;
	      }
	  }
	  
	  return false;
  }

}
