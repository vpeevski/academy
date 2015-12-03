package datastructure.linked;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import datastructure.List;

public class LinkedListTest {

	@Test
	public void testAdd() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i, list.get(i).intValue());
		}
	}
	
	@Test
	public void testAddIndexLast() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i, i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i/2, list.get(i/2).intValue());
		}
	}
	
	@Test
	public void testAddIndexMiddle() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i/2, i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i, list.get(i/2).intValue());
		}
	}

}
