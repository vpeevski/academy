package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ArrayQueueTest {

	@Test
	public void dequeueEmptyQueueTest() {
		Queue<String> queue = new ArrayQueue<String>();
		queue.enqueue("five");
		assertEquals("five", queue.dequeue());
		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}
	}

	@Test
	public void enqueueDequeueTest() {

		Queue<Integer> queue = new ArrayQueue<Integer>();
		for (int i = 0; i < 15; i++) {
			assertEquals(queue.lenght(), i);
			queue.enqueue(1);
			assertEquals(queue.lenght(), i + 1);
		}

		for (int i = 8; 0 < i; i--) {
			assertEquals(queue.lenght(), i + 7);
			assertEquals(queue.dequeue().intValue(), 1);
			assertEquals(queue.lenght(), i + 6);
		}

		for (int i = 0; i < 15; i++) {
			assertEquals(queue.lenght(), i + 7);
			queue.enqueue(1);
			assertEquals(queue.lenght(), i + 8);
		}

		for (int i = 22; 0 < i; i--) {
			assertEquals(queue.lenght(), i);
			assertEquals(queue.dequeue().intValue(), 1);
			assertEquals(queue.lenght(), i - 1);
		}

		try {
			queue.dequeue();
			fail("NoSuchElementException expexted !");
		} catch (NoSuchElementException noSushElemEx) {
			assertTrue(true);
		}

		assertTrue(queue.isEmpty());
	}

	@Test
	public void isEmptyQueueTest() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		assertTrue(queue.isEmpty());
		queue.enqueue(1);
		assertTrue(!queue.isEmpty());
	}

	@Test
	public void lenghtQueueTest() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		assertEquals(0, queue.lenght());
		queue.enqueue(1);
		assertEquals(1, queue.lenght());
	}

	@Test
	public void testEquals() {
		Queue<Integer> queue1 = new ArrayQueue<Integer>();
		Queue<Integer> queue2 = new ArrayQueue<Integer>();
		for (int i = 0; i < 100; i++) {
			queue1.enqueue(i);
			queue2.enqueue(i);
		}

		assertEquals(queue2, queue1);

		Queue<Integer> listOther = queue1;
		assertEquals(queue1, listOther);
		assertEquals(queue1, queue2);
	}

	@Test
	public void testHashCode() {
		Queue<Integer> queue1 = new ArrayQueue<Integer>();
		Queue<Integer> queue2 = new ArrayQueue<Integer>();
		for (int i = 0; i < 100; i++) {
			queue1.enqueue(i);
			queue2.enqueue(i);
		}

		assertEquals(queue1.hashCode(), queue1.hashCode());
		assertEquals(queue1.hashCode(), queue2.hashCode());
	}

	@Test
	public void testIterator() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		for (int i = 0; i < 1000; i++) {
			queue.enqueue(i);
		}

		int i = 0;
		Iterator<Integer> iter = queue.iterator();
		for (; iter.hasNext();) {
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
	public void testContains() {
		Queue<String> queue = new ArrayQueue<String>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(String.valueOf(i));
		}

		assertTrue(queue.contains("0"));
		assertTrue(queue.contains("1"));
		assertTrue(queue.contains("2"));
		assertTrue(queue.contains("3"));
		assertTrue(queue.contains("4"));
		assertTrue(queue.contains("5"));
		assertTrue(queue.contains("6"));
		assertTrue(queue.contains("7"));
		assertTrue(queue.contains("8"));
		assertTrue(queue.contains("9"));
		assertTrue(queue.contains("3"));
		assertTrue(queue.contains("4"));
		assertTrue(queue.contains("5"));
		assertTrue(queue.contains("6"));
		assertTrue(queue.contains("7"));
		assertTrue(!queue.contains("10"));
		assertTrue(queue.contains("3"));
		assertTrue(queue.contains("4"));
		assertTrue(queue.contains("5"));
		assertTrue(queue.contains("6"));
		assertTrue(queue.contains("7"));

	}

	@Test
	public void testIteratorGoesToTheEnd() {
		final int numberOfElements = 400;
		Queue<String> queue = new ArrayQueue<String>();
		for (int i = 0; i < numberOfElements; i++) {
			queue.enqueue(String.valueOf(i));
		}
		Iterator<String> iter = queue.iterator();
		for (int i = 0; i < numberOfElements; i++) {
			assertEquals(String.valueOf(i), iter.next());
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
