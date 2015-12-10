package datastructure;


public class ArrayListTest extends AbstractListTest {

  @Override
  protected <T> List<T> provideList(Class<T> clazz) {
    return new ArrayList<T>();
  }
	

}
