package recursion;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FibonachiTest {

	@Test
	public void testFibonachiRec() {
		long fibonachi20 = Fibonachi.generateRec(20);
		Fibonachi.print(20);
		assertEquals(fibonachi20, 4181);
		
		long fibonachi1 = Fibonachi.generateRec(1);
		assertEquals(fibonachi1, 0);
		
		long fibonachi2 = Fibonachi.generateRec(2);
		assertEquals(fibonachi2, 1);
		
		long fibonachi3 = Fibonachi.generateRec(3);
		assertEquals(fibonachi3, 1);
	}
	
	@Test
	public void testFibonachiIter() {
		long fibonachi20 = Fibonachi.generateIter(20);
		assertEquals(fibonachi20, 4181);
		
		long fibonachi1 = Fibonachi.generateIter(1);
		assertEquals(fibonachi1, 0);
		
		long fibonachi2 = Fibonachi.generateIter(2);
		assertEquals(fibonachi2, 1);
		
		long fibonachi3 = Fibonachi.generateIter(3);
		assertEquals(fibonachi3, 1);
	}
	
	@Test
	public void testPrintFibonachiRec() {
		Long fib20 = Fibonachi.printFibonachiRec(20);
		assertEquals(fib20.longValue(), 4181);
		
		long fibonachi1 = Fibonachi.printFibonachiRec(1);
		assertEquals(fibonachi1, 0);
		
		long fibonachi2 = Fibonachi.printFibonachiRec(2);
		assertEquals(fibonachi2, 1);
		
		long fibonachi3 = Fibonachi.printFibonachiRec(3);
		assertEquals(fibonachi3, 1);
	}
	
	@Test
	public void testFibonachiPrintRec() {
		List<Long> fibNumbers = new ArrayList<Long>();
		fibNumbers.add(0L);
		fibNumbers.add(1L);
		fibNumbers.add(1L);
		long fibonachi20 = Fibonachi.generateRec(20, fibNumbers);
		System.out.println("############## Recursive Fibonachi With Collection- ("+ 20 +") ################");
		for (int i = 0; i < fibNumbers.size(); i++) {
			System.out.println("Fibonachi [" + (i + 1) + "] - " + fibNumbers.get(i));
		}
		assertEquals(fibonachi20, 4181);
	}

}
