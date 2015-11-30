package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueTest {

	@Test
	public void dequeueEmptyQueueTest() {
		ArrayQueue queue = new ArrayQueue();
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
	  
		ArrayQueue queue = new ArrayQueue();
		for (int i = 0; i < 15; i++) {
		  assertEquals(queue.lenght(), i);
		  queue.enqueue(1);
		  assertEquals(queue.lenght(), i + 1);
        }
		
		for (int i = 8; 0 < i ; i--) {
		  assertEquals(queue.lenght(), i + 7);
		  assertEquals(queue.dequeue(), 1);
		  assertEquals(queue.lenght(), i + 6);
        }
		
		for (int i = 0; i < 15; i++) {
          assertEquals(queue.lenght(), i + 7);
          queue.enqueue(1);
          assertEquals(queue.lenght(), i + 8);
        }
		
		for (int i = 22; 0 < i; i--) {
          assertEquals(queue.lenght(), i);
          assertEquals(queue.dequeue(), 1);
          assertEquals(queue.lenght(), i - 1 );
        }

		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}
		
		assertTrue(queue.isEmpty());
	}

}