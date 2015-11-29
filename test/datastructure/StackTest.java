package datastructure;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

public class StackTest {
	
	@Test
	public void pushInFullStackTest () {
		Stack stack = new Stack(1);
		stack.push(5);
		try {
			stack.push(5);
			fail("StackOverflowError expexted !");
		} catch (StackOverflowError stackOverFlow) {
			assertTrue(true);
		}
	}
	
	@Test
	public void popEmptyStackTest () {
		Stack stack = new Stack(1);
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
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		try {
			stack.push(6);
			fail("StackOverflowError expexted !");
		} catch (StackOverflowError stackOverFlow) {
			assertTrue(true);
		}
		
		assertEquals(stack.pop(), 5);
		assertEquals(stack.pop(), 4);
		assertEquals(stack.pop(), 3);
		assertEquals(stack.pop(), 2);
		assertEquals(stack.pop(), 1);
		
		try {
			stack.pop();
			fail("EmptyStackException expexted !");
		} catch (EmptyStackException stackOverFlow) {
			assertTrue(true);
		}
	}

}
