package datastructure.linked;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.NoSuchElementException;

import org.junit.Test;

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

}
