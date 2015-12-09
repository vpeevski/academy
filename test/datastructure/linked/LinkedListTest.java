package datastructure.linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import datastructure.List;

public class LinkedListTest {

	@Test
	public void testAdd() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i, list.get(i).intValue());
		}
	}
	
	@Test
	public void testIterator() {
		List<Integer> list = new LinkedList<Integer>();
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
	public void testAddIndexLast() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i, i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i/2, list.get(i/2).intValue());
		}
		
		try {
			list.set(1001, 1001);
			fail("IndexOutOfBoundsException expected !");
		} catch (IndexOutOfBoundsException ioobE) {
			assertTrue(true);
		}
		
		try {
			list.get(1001);
			fail("IndexOutOfBoundsException expected !");
		} catch (IndexOutOfBoundsException ioobE) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testAddIndexMiddle() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i/2, i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i, list.get(i/2).intValue());
		}
	}
	
	@Test
	public void testRemove () {
	  List<Integer> list = new LinkedList<Integer>();
	  for (int i = 0; i < 10 ; i++) {
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

}
