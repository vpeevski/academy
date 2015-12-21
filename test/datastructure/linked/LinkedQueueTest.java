package datastructure.linked;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import datastructure.List;
import datastructure.Queue;

public class LinkedQueueTest {

	@Test
	public void dequeueEmptyQueueTest() {
		Queue<Integer> queue = new LinkedQueue<Integer>();
		queue.enqueue(5);
		queue.dequeue();
		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}
	}

	@Test
	public void enqueueDequeueTest() {
		Queue<String> queue = new LinkedQueue<String>();
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
		queue.enqueue("five");

		assertEquals(queue.dequeue(), "one");
		assertEquals(queue.dequeue(), "two");
		assertEquals(queue.dequeue(), "three");
		assertEquals(queue.dequeue(), "four");
		assertEquals(queue.dequeue(), "five");

		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}
	}
	
	@Test
	  public void isEmptyQueueTest() {
	    Queue<Integer> queue = new LinkedQueue<Integer>();
	    assertTrue(queue.isEmpty());
	    queue.enqueue(1);
	    assertTrue(!queue.isEmpty());
	  }

	  @Test
	  public void lenghtQueueTest() {
	    Queue<Integer> queue = new LinkedQueue<Integer>();
	    assertEquals(0, queue.lenght());
	    queue.enqueue(1);
	    assertEquals(1, queue.lenght());
	  }
	  
	  @Test
	  public void testIterator() {
	      Queue<Integer> queue = new LinkedQueue<Integer>();
	      for (int i = 0; i < 1000 ; i++) {
	        queue.enqueue(i);
	      }
	      
	      int i = 0;
	      Iterator<Integer> iter = queue.iterator();
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


}
