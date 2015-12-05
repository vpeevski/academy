package recursion;

import datastructure.ArrayQueue;
import datastructure.ArrayStack;
import datastructure.Queue;
import datastructure.Stack;
import datastructure.linked.LinkedQueue;

public class Reverse {
	
	public int[] reverseArray (int[] inputArray) {
		int[] reversedArray = new int[inputArray.length];
		reverseRec (inputArray, reversedArray, 0);
		return  reversedArray;
	}
	
	public void reverseArraySelf (int[] inputArray) {
		reverseSelfRec (inputArray, 0);
	}
	
	public void reverseArraySelfStack (int[] inputArray) {
		Stack<Integer> stack = new ArrayStack<Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			stack.push(inputArray[i]);
		}
		
		int i = 0;
		while(!stack.isEmpty()) {
			inputArray[i++] = stack.pop();
		}
	}
	
	public Queue<Integer> reverseQueue (Queue<Integer> queue) {
		return reverseQueueRec (queue);
	}
	
	private Queue<Integer> reverseQueueRec(Queue<Integer> queue) {
		if (queue.isEmpty()) {
			return new ArrayQueue<Integer>();
		}
		
		if (queue.lenght() == 1) {
			Queue<Integer> reversed = new LinkedQueue<Integer>();
			reversed.enqueue(queue.dequeue());
			return reversed;
		}
		
		int value = queue.dequeue();
		Queue<Integer> reversed = reverseQueueRec(queue);
		reversed.enqueue(value);
		return reversed;
		
	}

	private void reverseRec (int[] inputArray, int[] reversedArray, int currentIndex) {
		if(currentIndex == inputArray.length) {
			return;
		}
		
		reverseRec (inputArray, reversedArray, ++currentIndex);
		reversedArray[reversedArray.length - currentIndex] = inputArray[currentIndex - 1];	
	}
	
	private void reverseSelfRec (int[] inputArray, int currentIndex) {
		if(currentIndex == inputArray.length) {
			return;
		}
		
		int index = currentIndex + 1;
		int value = inputArray[currentIndex];
		reverseSelfRec (inputArray, index);
		inputArray[inputArray.length - index] = value;	
	}
	
}
