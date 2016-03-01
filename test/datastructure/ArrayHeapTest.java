package datastructure;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayHeapTest {

  @Test
  public void testMaxHeap() {
    Integer[] arr = { 1, 2, 3, 4, 7, 8, 10, 6 };
    ArrayHeap<Integer> heap = new ArrayHeap<Integer>(arr, ArrayHeap.HEAP_TYPE_MAX);
    assertEquals(10, heap.pull().intValue());
    assertEquals(8, heap.pull().intValue());
    assertEquals(7, heap.pull().intValue());
    assertEquals(6, heap.pull().intValue());
    assertEquals(4, heap.pull().intValue());
    assertEquals(3, heap.pull().intValue());
    assertEquals(2, heap.pull().intValue());
    assertEquals(1, heap.pull().intValue());

    try {
      heap.pull();
      fail("NoSuchElementException expected !");
    } catch (NoSuchElementException nseE) {
      assertTrue(true);
    }
  }

  @Test
  public void testMinHeap() {
    Integer[] arr = { 1, 2, 3, 4, 7, 8, 10, 6 };
    ArrayHeap<Integer> heap = new ArrayHeap<Integer>(arr, ArrayHeap.HEAP_TYPE_MIN);
    assertEquals(1, heap.pull().intValue());
    assertEquals(2, heap.pull().intValue());
    assertEquals(3, heap.pull().intValue());
    assertEquals(4, heap.pull().intValue());
    assertEquals(6, heap.pull().intValue());
    assertEquals(7, heap.pull().intValue());
    assertEquals(8, heap.pull().intValue());
    assertEquals(10, heap.pull().intValue());

    try {
      heap.pull();
      fail("NoSuchElementException expected !");
    } catch (NoSuchElementException nseE) {
      assertTrue(true);
    }
  }

  @Test
  public void testMaxInsertion() {
    ArrayHeap<Integer> heap = new ArrayHeap<Integer>(ArrayHeap.HEAP_TYPE_MAX);
    heap.insert(1);
    heap.insert(3);
    heap.insert(7);
    heap.insert(8);
    heap.insert(10);
    heap.insert(2);
    heap.insert(6);
    heap.insert(4);

//    try {
//      heap.insert(20);
//      fail("IndexOutOfBoundsException expected !");
//    } catch (IndexOutOfBoundsException iobE) {
//      assertTrue(true);
//    }

    assertEquals(10, heap.pull().intValue());
    assertEquals(8, heap.pull().intValue());
    assertEquals(7, heap.pull().intValue());
    assertEquals(6, heap.pull().intValue());
    assertEquals(4, heap.pull().intValue());
    assertEquals(3, heap.pull().intValue());
    assertEquals(2, heap.pull().intValue());
    assertEquals(1, heap.pull().intValue());

    try {
      heap.pull();
      fail("NoSuchElementException expected !");
    } catch (NoSuchElementException nseE) {
      assertTrue(true);
    }
  }

  @Test
  public void testMinInsertion() {
    ArrayHeap<Integer> heap = new ArrayHeap<Integer>(ArrayHeap.HEAP_TYPE_MIN);
    heap.insert(1);
    heap.insert(7);
    heap.insert(8);
    heap.insert(2);
    heap.insert(3);
    heap.insert(10);
    heap.insert(6);
    heap.insert(4);

//    try {
//      heap.insert(20);
//      fail("IndexOutOfBoundsException expected !");
//    } catch (IndexOutOfBoundsException iobE) {
//      assertTrue(true);
//    }

    assertEquals(1, heap.pull().intValue());
    assertEquals(2, heap.pull().intValue());
    assertEquals(3, heap.pull().intValue());
    assertEquals(4, heap.pull().intValue());
    assertEquals(6, heap.pull().intValue());
    assertEquals(7, heap.pull().intValue());
    assertEquals(8, heap.pull().intValue());
    assertEquals(10, heap.pull().intValue());

    try {
      heap.pull();
      fail("NoSuchElementException expected !");
    } catch (NoSuchElementException nseE) {
      assertTrue(true);
    }
  }
  
  @Test
  public void testEquals() {
	  ArrayHeap<Integer> heap1 = new ArrayHeap<Integer>(100);
	  ArrayHeap<Integer> heap2 = new ArrayHeap<Integer>(100);
      for (int i = 0; i < 100; i++) {
    	  heap1.insert(i);
    	  heap2.insert(i);
      }
      
      assertEquals(heap1, heap2);
      
      assertEquals(heap1, heap1);
      assertEquals(heap1, heap2);
      assertEquals(heap2, heap1);
  }
  
  @Test
  public void testHashCode() {
	  ArrayHeap<Integer> heap1 = new ArrayHeap<Integer>(100);
	  ArrayHeap<Integer> heap2 = new ArrayHeap<Integer>(100);
      for (int i = 0; i < 100; i++) {
    	  heap1.insert(i);
    	  heap2.insert(i);
      }
      
      assertEquals(heap1.hashCode(), heap1.hashCode());
      assertEquals(heap1.hashCode(), heap2.hashCode());
      assertEquals(heap2.hashCode(), heap1.hashCode());
  }
  
  @Test
  public void testIterator() {
	  ArrayHeap<Integer> heap = new ArrayHeap<Integer>(3);
      for (int i = 0; i < 3 ; i++) {
    	  heap.insert(i);
      }
      
      Iterator<Integer> iter = heap.iterator();
      assertEquals(2, iter.next().intValue());
      assertEquals(0, iter.next().intValue());
      assertEquals(1, iter.next().intValue());
      
      try {
          iter.next();
          fail("NoSuchElementException expected");
      } catch (NoSuchElementException nseE) {
          assertTrue(true);
      }
      
      assertTrue(!iter.hasNext());
  }
  
  @Test
  public void testContains() {
	  ArrayHeap<String> heap = new ArrayHeap<String> (10);
	    for (int i = 0; i < 10; i++) {
	      heap.insert(String.valueOf(i));
	    }
	    
	    assertTrue(heap.contains("0"));
	    assertTrue(heap.contains("1"));
	    assertTrue(heap.contains("2"));
	    assertTrue(heap.contains("3"));
	    assertTrue(heap.contains("4"));
	    assertTrue(heap.contains("5"));
	    assertTrue(heap.contains("6"));
	    assertTrue(heap.contains("7"));
	    assertTrue(heap.contains("8"));
	    assertTrue(heap.contains("9"));
	    assertTrue(heap.contains("3"));
	    assertTrue(heap.contains("4"));
	    assertTrue(heap.contains("5"));
	    assertTrue(heap.contains("6"));
	    assertTrue(heap.contains("7"));
	    assertTrue(!heap.contains("10"));
	    assertTrue(heap.contains("3"));
	    assertTrue(heap.contains("4"));
	    assertTrue(heap.contains("5"));
	    assertTrue(heap.contains("6"));
	    assertTrue(heap.contains("7"));

	  }

}
