package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import datastructure.linked.LinkedQueue;

public abstract class AbstractListTest {
  
  @Test
  public void testAddIndex() {
      List<Integer> list = provideList(Integer.class);
      list.add(0, 5);
      assertEquals(5, list.get(0).intValue());

  }
  
  @Test
  public void testAdd() {
    List<String> list = provideList(String.class);
    for (int i = 0; i < 1000; i++) {
      assertEquals(i, list.lenght());
      list.add(String.valueOf(i));
      assertEquals(i + 1, list.lenght());
      assertEquals(String.valueOf(i), list.get(i));
    }
  }
  
  @Test
  public void testAddIndexOutOfBounds() {
      List<Integer> list = provideList(Integer.class);
      try {
          list.add(1, 5);
          fail("IndexOutOfBoundsException expected !");
      } catch (IndexOutOfBoundsException ioobE) {
          assertTrue(true);
      }

  }
  
  @Test
  public void testSetIndexOutOfBounds() {
      List<Integer> list = provideList(Integer.class);
      try {
          list.set(0, 5);
          fail("IndexOutOfBoundsException expected !");
      } catch (IndexOutOfBoundsException ioobE) {
          assertTrue(true);
      }

  }
  
  @Test
  public void testAddIndexFront() {
      List<Integer> list = provideList(Integer.class);
      for (int i = 0; i < 100; i++) {
          list.add(i);
          assertEquals(i, list.get(i).intValue());
      }
      
      list.add(0, 6);
      assertEquals(6, list.get(0).intValue());
      assertEquals(101, list.lenght());

  }
  
  @Test
  public void testGetFromEmptyList() {
      List<Integer> list = provideList(Integer.class);
      try {
          list.get(0);
          fail("IndexOutOfBoundsException expected !");
      } catch (IndexOutOfBoundsException ioobE) {
          assertTrue(true);
      }
  }
  
  @Test
  public void testSetAddGetSetGet() {
      List<Integer> list = provideList(Integer.class);
      list.add(4);
      assertEquals(4, list.get(0).intValue());
      list.set(0, 5);
      assertEquals(5, list.get(0).intValue());

  }


  @Test
  public void testRemove() {
    List<Integer> list = provideList(Integer.class);
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    int zero = list.remove(0);
    assertEquals(0, zero);
    assertTrue(list.lenght() == 9);

    int nine = list.remove(8);
    assertEquals(9, nine);
    assertTrue(list.lenght() == 8);

    boolean isRemoved = list.remove(Integer.valueOf(5));
    assertTrue(isRemoved);
    assertTrue(list.lenght() == 7);

    boolean isRemovedNotExisting = list.remove(Integer.valueOf(5));
    assertTrue(!isRemovedNotExisting);
    assertTrue(list.lenght() == 7);

    try {
      list.remove(7);
      fail("IndexOutOfBoundsException expected !");
    } catch (IndexOutOfBoundsException iobE) {
      assertTrue(true);
    }

    assertTrue(list.remove(Integer.valueOf(6)));
    assertTrue(list.lenght() == 6);

    int eight = list.remove(5);
    assertEquals(eight, 8);
    assertEquals(list.lenght(), 5);

  }
  
  @Test
  public void testIterator() {
      List<Integer> list = provideList(Integer.class);
      for (int i = 0; i < 1000 ; i++) {
          list.add(i);
      }
      
      int i = 0;
      Iterator<Integer> iter = list.iterator();
      for ( ; iter.hasNext() ; ) {
          assertEquals(i, iter.next().intValue());
          i++;
      }
      
      try {
          iter.next();
          fail("NoSuchElementException expected");
      } catch (NoSuchElementException nseE) {
          assertTrue(true);
      }
      
      assertTrue(!iter.hasNext());
  }
  
  @Test
  public void testEquals() {
      List<Integer> list1 = provideList(Integer.class);
      List<Integer> list2 = provideList(Integer.class);
      for (int i = 0; i < 100; i++) {
          list1.add(i);
          list2.add(i);
      }
      
      assertEquals(list1, list1);
      
      List<Integer> listOther = list1;
      assertEquals(list1, listOther);
      assertEquals(list1, list2);
  }
  
  @Test
  public void testHashCode() {
      List<Integer> list1 = provideList(Integer.class);
      List<Integer> list2 = provideList(Integer.class);
      for (int i = 0; i < 100; i++) {
          list1.add(i);
          list2.add(i);
      }
      
      assertEquals(list1.hashCode(), list1.hashCode());
      assertEquals(list1.hashCode(), list2.hashCode());
  }
  
  @Test
  public void testAddIndexLast() {
      List<Integer> list = provideList(Integer.class);

      list.add(0, 5);
      assertEquals(5, list.get(0).intValue());

  }

  @Test
  public void testAddIndexMiddle() {
      List<Integer> list = provideList(Integer.class);
      for (int i = 0; i < 1000; i++) {
          assertEquals(i, list.lenght());
          list.add(i / 2, i);

          assertEquals(i, list.get(i / 2).intValue());
      }
  }
  
  @Test
  public void testIteratorRemove() {
    List<Integer> list = provideList(Integer.class);
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    
    int i = 10;
    for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
      iterator.next();
      assertEquals(list.lenght(), i);
      iterator.remove();
      assertEquals(list.lenght(), --i);
    }

  }
  
  @Test
  public void testIteratorDoubleRemove() {
    List<Integer> list = provideList(Integer.class);
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    Iterator<Integer> iterator = list.iterator();
    iterator.next();
    iterator.remove();
    
    try {
      iterator.remove();
      fail("IllegalStateException ecpected on double remove from iterator withou intermediate call to next() method!");
    } catch (IllegalStateException isE) {
      assertTrue(true);
    }

  }
  
  @Test
  public void testIteratorRemoveWithoutNextCall() {
    List<Integer> list = provideList(Integer.class);
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    Iterator<Integer> iterator = list.iterator();
    try {
      iterator.remove();
      fail("IllegalStateException expected trying to remove from iterator without current element (next() method not called before remove)");
    } catch (IllegalStateException isE) {
      assertTrue(true);
    }
  }

  
  protected abstract <T> List<T> provideList (Class<T> clazz);

}
