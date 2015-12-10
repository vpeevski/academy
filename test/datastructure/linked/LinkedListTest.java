package datastructure.linked;

import datastructure.AbstractListTest;
import datastructure.List;

public class LinkedListTest extends AbstractListTest {

  @Override
  protected <T> List<T> provideList(Class<T> clazz) {
    return new LinkedList<T>();
  }

}
