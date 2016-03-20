package algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class NODTest {

	@Test
	public void testNodr() {
		NOD nodFinder = new NOD();
		int nod1 = nodFinder.nodr(84, 36);
		int nod2 = nodFinder.nodr(8, 12);
		assertEquals(12, nod1);
		assertEquals(4, nod2);
	}
	
	@Test
	public void testNod() {
		NOD nodFinder = new NOD();
		int nod1 = nodFinder.nod(18, 12);
		int nod2 = nodFinder.nod(8, 12);
		assertEquals(6, nod1);
		assertEquals(4, nod2);
	}
	
	@Test
	public void testNodDiv() {
		NOD nodFinder = new NOD();
		int nod1 = nodFinder.nodDiv(18, 12);
		int nod2 = nodFinder.nodDiv(8, 12);
		assertEquals(6, nod1);
		assertEquals(4, nod2);
	}
	
	@Test
	public void testNodNaive() {
		NOD nodFinder = new NOD();
		int nod1 = nodFinder.nodNaive(18, 12);
		int nod2 = nodFinder.nodNaive(36, 84);
		assertEquals(6, nod1);
		assertEquals(12, nod2);
	}
	
	@Test
	public void testNodMany() {
		NOD nodFinder = new NOD();
		int nod1 = nodFinder.nodMany(18, 12, 36, 84);
		//int nod2 = nodFinder.nodNaive(36, 84);
		assertEquals(6, nod1);
		//assertEquals(12, nod2);
	}
	
	@Test
	public void testNodManyR() {
		NOD nodFinder = new NOD();
		int[] array = {18, 12, 36, 84};
		int nod1 = nodFinder.nodManyR(0, array);
		//int nod2 = nodFinder.nodNaive(36, 84);
		assertEquals(6, nod1);
		//assertEquals(12, nod2);
	}

}
