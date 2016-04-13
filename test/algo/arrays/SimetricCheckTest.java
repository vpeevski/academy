package algo.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimetricCheckTest {
  
  private static int[] _inputSimetricArrayOdd = { 5, 3, 9, 10, 9, 3, 5};
  
  private static int[] _inputSimetricArrayEven = { 5, 3, 9, 9, 3, 5};
  
  private static int[] _inputNotSimetricArray = { 3, 9, 10, 9, 3, 5};

  @Test
  public void testIsSimetric () {
    boolean isSimetric = SimetricCheck.isSimetric(_inputSimetricArrayOdd);
    assertTrue(isSimetric);
    
    isSimetric = SimetricCheck.isSimetric(_inputSimetricArrayEven);
    assertTrue(isSimetric);
    
    isSimetric = SimetricCheck.isSimetric(_inputNotSimetricArray);
    assertTrue(!isSimetric);
  }
  
  @Test
  public void testIsSimetricWithBreak () {
    boolean isSimetric = SimetricCheck.isSimetricWithBreak(_inputSimetricArrayOdd);
    assertTrue(isSimetric);
    
    isSimetric = SimetricCheck.isSimetricWithBreak(_inputSimetricArrayEven);
    assertTrue(isSimetric);
    
    isSimetric = SimetricCheck.isSimetricWithBreak(_inputNotSimetricArray);
    assertTrue(!isSimetric);
  }


}
