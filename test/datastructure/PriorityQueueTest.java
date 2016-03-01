package datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueueTest {

	@Test
	public void testPriorityQueue() {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(20);
		assertEquals(30, queue.dequeue().intValue());
		assertEquals(20, queue.dequeue().intValue());
		assertEquals(10, queue.dequeue().intValue());
	}

}
