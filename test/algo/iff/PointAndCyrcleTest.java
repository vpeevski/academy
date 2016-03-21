package algo.iff;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointAndCyrcleTest {
  
  int rx = 5;
  int ry = 5;
  
  int r = 10;
  
  int px = 6;
  int py = 6;

  @Test
  public void testIsPointInCyrcle() {
    PointAndCyrcle checker = new PointAndCyrcle();
    assertTrue(checker.isPointInCyrcle(rx, ry, r, px, py));
    assertTrue(!checker.isPointInCyrcle(rx, ry, r, 15, 16));
    assertTrue(!checker.isPointInCyrcle(rx, ry, r, 15, 15));
    assertTrue(checker.isPointInCyrcle(rx, ry, r, 3, 3));
    assertTrue(!checker.isPointInCyrcle(rx, ry, r, -20, -20));
    assertTrue(!checker.isPointInCyrcle(rx, ry, r, -5, 0));
    assertTrue(!checker.isPointInCyrcle(rx, ry, r, 0, 15));
    assertTrue(checker.isPointInCyrcle(rx, ry, r, 5, -5));
    assertTrue(!checker.isPointInCyrcle(rx, ry, r, -4, -6));
    assertTrue(checker.isPointInCyrcle(rx, ry, r, -2, -2));
  }

}
