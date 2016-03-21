package algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberOfDigitsTest {

  @Test
  public void testCalculate() {
    int digitsCount = NumberOfDigits.calculate(127);
    assertEquals(3, digitsCount);
    
    
    digitsCount = NumberOfDigits.calculate(5);
    assertEquals(1, digitsCount);
    
    digitsCount = NumberOfDigits.calculate(789123456);
    assertEquals(9, digitsCount);
  }

}
