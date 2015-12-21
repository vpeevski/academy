package datastructure;

import static org.junit.Assert.*;

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
    ArrayHeap<Integer> heap = new ArrayHeap<Integer>(8, ArrayHeap.HEAP_TYPE_MAX);
    heap.insert(1);
    heap.insert(3);
    heap.insert(7);
    heap.insert(8);
    heap.insert(10);
    heap.insert(2);
    heap.insert(6);
    heap.insert(4);

    try {
      heap.insert(20);
      fail("IndexOutOfBoundsException expected !");
    } catch (IndexOutOfBoundsException iobE) {
      assertTrue(true);
    }

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
    ArrayHeap<Integer> heap = new ArrayHeap<Integer>(8, ArrayHeap.HEAP_TYPE_MIN);
    heap.insert(1);
    heap.insert(7);
    heap.insert(8);
    heap.insert(2);
    heap.insert(3);
    heap.insert(10);
    heap.insert(6);
    heap.insert(4);

    try {
      heap.insert(20);
      fail("IndexOutOfBoundsException expected !");
    } catch (IndexOutOfBoundsException iobE) {
      assertTrue(true);
    }

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

}
