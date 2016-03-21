package algo.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleCheckTest {
  
  private static int[] _inputTriangleArray = { 1, 5, 9, 10, 7, 5, 3, 1 };
  
  private static int[] _inputLinearArray = { 1, 5, 9, 10};
  
  private static int[] _inputMArray = { 1, 5, 9, 10, 7, 5, 3, 5, 6, 7, 4};

  @Test
  public void testIsTriangle() {
    boolean isTriangle = TriangleCheck.isTriangle(_inputTriangleArray);
    assertTrue(isTriangle);
    isTriangle = TriangleCheck.isTriangle(_inputLinearArray);
    assertTrue(!isTriangle);
    isTriangle = TriangleCheck.isTriangle(_inputMArray);
    assertTrue(!isTriangle);
  }

}
