package algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class NODTest {

	@Test
	public void testNodr() {
		int nod1 = NOD.nodr(84, 36);
		int nod2 = NOD.nodr(8, 12);
		assertEquals(12, nod1);
		assertEquals(4, nod2);
	}
	
	@Test
	public void testNod() {
		int nod1 = NOD.nod(18, 12);
		int nod2 = NOD.nod(8, 12);
		assertEquals(6, nod1);
		assertEquals(4, nod2);
	}
	
	@Test
	public void testNodDiv() {
		int nod1 = NOD.nodDiv(18, 12);
		int nod2 = NOD.nodDiv(8, 12);
		assertEquals(6, nod1);
		assertEquals(4, nod2);
	}
	
	@Test
	public void testNodNaive() {
		int nod1 = NOD.nodNaive(18, 12);
		int nod2 = NOD.nodNaive(36, 84);
		assertEquals(6, nod1);
		assertEquals(12, nod2);
	}
	
	@Test
	public void testNodMany() {
		int nod1 = NOD.nodMany(18, 12, 36, 84);
		assertEquals(6, nod1);
	}
	
	@Test
	public void testNodManyR() {
		int[] array = {18, 12, 36, 84};
		int nod1 = NOD.nodManyR(0, array);
		assertEquals(12, nod1);
	}

}
