package datastructure;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import datastructure.linked.LinkedQueue;
import datastructure.linked.LinkedStack;

public class ArrayStackTest {

  @Test
  public void popEmptyStackTest() {
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
  public void pushPopStackTest() {
    Stack<Integer> stack = new ArrayStack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(6);

    assertEquals(stack.pop().intValue(), 6);
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

  @Test
  public void isEmptyStackTest() {
    Stack<Integer> stack = new ArrayStack<Integer>();
    assertTrue(stack.isEmpty());
    stack.push(1);
    assertTrue(!stack.isEmpty());
  }
  
  
  @Test
  public void lenghtStackTest() {
    Stack<Integer> stack = new ArrayStack<Integer>();
    assertEquals(0, stack.lenght());
    stack.push(1);
    assertEquals(1, stack.lenght());
  }
  
  @Test
  public void testEquals() {
	  Stack<Integer> stack1 = new ArrayStack<Integer>();
	  Stack<Integer> stack2 = new ArrayStack<Integer>();
      for (int i = 0; i < 100; i++) {
    	  stack1.push(i);
    	  stack2.push(i);
      }
      
      assertEquals(stack1, stack1);
      
      Stack<Integer> stackOther = stack1;
      assertEquals(stack1, stackOther);
      assertEquals(stack1, stack2);
  }
  
  @Test
  public void testHashCode() {
	  Stack<Integer> stack1 = new ArrayStack<Integer>();
	  Stack<Integer> stack2 = new ArrayStack<Integer>();
      for (int i = 0; i < 100; i++) {
    	  stack1.push(i);
    	  stack2.push(i);
      }
      
      assertEquals(stack1.hashCode(), stack1.hashCode());
      assertEquals(stack1.hashCode(), stack2.hashCode());
      assertEquals(stack2.hashCode(), stack1.hashCode());
  }
  
  @Test
  public void testIterator() {
      Stack<Integer> stack = new ArrayStack<Integer>();
      for (int i = 0; i < 1000 ; i++) {
        stack.push(i);
      }
      
      int i = 999;
      Iterator<Integer> iter = stack.iterator();
      for ( ; iter.hasNext() ; ) {
          assertEquals(i, iter.next().intValue());
          i--;
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
