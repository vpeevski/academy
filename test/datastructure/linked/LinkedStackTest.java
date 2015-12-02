package datastructure.linked;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

import datastructure.Stack;

public class LinkedStackTest {
	
//	@Test
//	public void pushInFullStackTest () {
//		LinkedStack stack = new LinkedStack();
//		stack.push(5);
//		try {
//			stack.push(5);
//			fail("StackOverflowError expexted !");
//		} catch (StackOverflowError stackOverFlow) {
//			assertTrue(true);
//		}
//	}
	
	@Test
	public void popEmptyStackTest () {
		Stack<Integer> stack = new LinkedStack<Integer>();
		stack.push(5);
		stack.pop();
		try {
			stack.pop();
			fail("EmptyStackException expexted !");
		} catch (EmptyStackException stackOverFlow) {
			assertTrue(true);
		}
	}
	
	@Test
	public void pushPopStackTest () {
		Stack<Integer> stack = new LinkedStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		assertEquals(stack.pop().intValue(), 5);
		assertEquals(stack.pop().intValue(), 4);
		assertEquals(stack.pop().intValue(), 3);
		assertEquals(stack.pop().intValue(), 2);
		assertEquals(stack.pop().intValue(), 1);
		
		try {
			stack.pop();
			fail("EmptyStackException expexted !");
		} catch (EmptyStackException stackOverFlow) {
			assertTrue(true);
		}
	}

}
