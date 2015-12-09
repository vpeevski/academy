package recursion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FactorielTest {

  @Test
  public void testFactorielRec() {
    long fact = Factoriel.factorielRec(5);
    assertEquals(120, fact);
    
    fact = Factoriel.factorielRec(10);
    assertEquals(3628800, fact);
    
    try {
      fact = Factoriel.factorielRec(1000);
      fail("ArithmeticException expected !");
    } catch (ArithmeticException aE) {
      assertTrue(true);
    }
    
  }
  
  @Test
  public void testFactorielRecIllegalArgument() {
    try {
      Factoriel.factorielRec(0);
      fail("IllegalArgumentException expected for: " + 0);
    } catch (IllegalArgumentException iaE) {
      assertTrue(true);
    }
    
    try {
      Factoriel.factorielRec(-1);
      fail("IllegalArgumentException expected for: " + 0);
    } catch (IllegalArgumentException iaE) {
      assertTrue(true);
    }
  }

}
