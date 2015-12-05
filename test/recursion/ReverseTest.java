package recursion;

import org.junit.Test;

import datastructure.ArrayQueue;
import datastructure.Queue;
import static org.junit.Assert.assertArrayEquals;

public class ReverseTest {

	@Test
	public void testReverseArray() {
		int[] array = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10};
		Reverse reverser = new Reverse();
		int[] reversedArray = reverser.reverseArray(array);
		int[] expected = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		assertArrayEquals(expected, reversedArray);
	}
	
	@Test
	public void testReverseArraySelf() {
		int[] array = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10};
		Reverse reverser = new Reverse();
		reverser.reverseArraySelf(array);
		int[] expected = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		assertArrayEquals(expected, array);
	}
	
	@Test
	public void testReverseArraySelfStack() {
		int[] array = {1, 2, 3 , 4, 5, 6, 7, 8, 9, 10};
		Reverse reverser = new Reverse();
		reverser.reverseArraySelfStack(array);
		int[] expected = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		assertArrayEquals(expected, array);
	}
	
	@Test
	public void testReverseQueue() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		Reverse reverser = new Reverse();
		Queue<Integer> reversed = reverser.reverseQueue(queue);
		System.out.println(reversed);
	}

}
