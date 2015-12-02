package datastructure;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

import org.junit.Test;

public class StackTest {
	
	@Test
	public void popEmptyStackTest () {
		Stack<String> stack = new ArrayStack<String>();
		stack.push("a");
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
		Stack<Integer> stack = new ArrayStack<Integer>();
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
