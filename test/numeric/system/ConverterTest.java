package numeric.system;

import org.junit.Assert;
import org.junit.Test;

public class ConverterTest {

	@Test
	public void testPositiveDecToBin() {
		String bin = Converter.decToBin(1234567);
		Assert.assertEquals("100101101011010000111", bin); 
	}
	
	@Test
	public void testNegativeDecToBin() {
		String bin = Converter.decToBin(-5);
		Assert.assertEquals("-101", bin); 
	}
	
	@Test
	public void testBinToDec() {
		int dec = Converter.binToDec("100101000010111");
		Assert.assertEquals(18967, dec); 
	}
	
	@Test
	public void testHexToDec() {
		int dec = Converter.hexToDec("5486B");
		Assert.assertEquals(346219, dec); 
	}
	
	@Test
	public void testDecToHex() {
		String hex = Converter.decToHex(346219);
		Assert.assertEquals("5486b", hex); 
	}
	
	@Test
	public void testDobleDecToBin() {
		String bin = Converter.decToBin(21.34, 0.00000000000000000000000000000000000000000000001);
		System.out.println(bin);
		//Assert.assertEquals("-101", bin); 
	}

}
