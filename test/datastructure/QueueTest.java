package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

public class QueueTest {

	@Test
	public void dequeueEmptyQueueTest() {
		Queue queue = new Queue(1);
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
		Queue queue = new Queue(5);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		try {
		 queue.enqueue(6);
		 fail("IndexOutOfBoundsException expexted !");
		} catch (IndexOutOfBoundsException iobEx) {
			assertTrue(true);
		}
		
		assertEquals(queue.dequeue(), 1);
		assertEquals(queue.dequeue(), 2);
		
		queue.enqueue(6);
		queue.enqueue(7);
		
		
		assertEquals(queue.dequeue(), 3);
		assertEquals(queue.dequeue(), 4);
		assertEquals(queue.dequeue(), 5);
		assertEquals(queue.dequeue(), 6);
		assertEquals(queue.dequeue(), 7);

		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}
	}

}
