package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testAdd() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i);
			assertEquals(i + 1, list.lenght());
			assertEquals(i, list.get(i).intValue());
		}
	}
	
	@Test
	public void testAddIndex() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0, 5);
		assertEquals(5, list.get(0).intValue());
		
	}
	
	@Test
	public void testAddIndexOutOfBounds() {
		List<Integer> list = new ArrayList<Integer>();
		try {
			list.add(1, 5);
			fail("IndexOutOfBoundsException expected !");
		} catch (IndexOutOfBoundsException ioobE) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testSetAddGetSetGet() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		assertEquals(4, list.get(0).intValue());
		list.set(0, 5);
		assertEquals(5, list.get(0).intValue());
		
	}
	
	@Test
	public void testSetIndexOutOfBounds() {
		List<Integer> list = new ArrayList<Integer>();
		try {
			list.set(0, 5);
			fail("IndexOutOfBoundsException expected !");
		} catch (IndexOutOfBoundsException ioobE) {
			assertTrue(true);
		}
		
	}
	
	@Test
	public void testAddIndexMiddle() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000 ; i++) {
			assertEquals(i, list.lenght());
			list.add(i/2, i);
			
			assertEquals(i, list.get(i/2).intValue());
		}
	}
	
	@Test
	public void testGetFromEmptyList () {
		List<Integer> list = new ArrayList<Integer>();
		try {
			list.get(0);
			fail("IndexOutOfBoundsException expected !");
		} catch (IndexOutOfBoundsException ioobE) {
			assertTrue(true);
		}
	}

}
