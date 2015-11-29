package datastructure.linked;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

public class LinkedQueueTest {

	@Test
	public void dequeueEmptyQueueTest() {
		LinkedQueue queue = new LinkedQueue();
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
		LinkedQueue queue = new LinkedQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);

		assertEquals(queue.dequeue(), 1);
		assertEquals(queue.dequeue(), 2);
		assertEquals(queue.dequeue(), 3);
		assertEquals(queue.dequeue(), 4);
		assertEquals(queue.dequeue(), 5);

		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}
	}

}
