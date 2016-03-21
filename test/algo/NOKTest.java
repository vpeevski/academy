package algo;

import static org.junit.Assert.*;

import org.junit.Test;

public class NOKTest {

  @Test
  public void testNOKNaive() {
    
    long nok =  NOK.nokNaive(8, 20);
    assertEquals(40, nok);
    nok =  NOK.nokNaive(35, 25);
    assertEquals(175, nok);
  }
  
  @Test
  public void testNOKEffective() {
    
    long nok =  NOK.nok(8, 20);
    assertEquals(40, nok);
    nok =  NOK.nok(35, 25);
    assertEquals(175, nok);
  }
  
  @Test
  public void testNOKMany() {
    
    long nok =  NOK.nokMany(8, 20, 10, 4);
    assertEquals(40, nok);
    nok =  NOK.nokMany(35, 25, 5);
    assertEquals(175, nok);
  }

}
