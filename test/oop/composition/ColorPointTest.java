package oop.composition;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ColorPointTest {

  @Test
  public void testEqualsReflexive() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    
    assertTrue(p1.equals(p1));
  }
  
  @Test
  public void testEqualsNotNull() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    
    assertTrue(!p1.equals(null));
  }

  @Test
  public void testEqualsSymetry() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    ColorPoint p2 = new ColorPoint(5, 10, 100);
    
    assertTrue(p2.equals(p1));
    assertTrue(p1.equals(p2));
  }
  
  @Test
  public void testEqualsSymetryDiffY() {
    ColorPoint p1 = new ColorPoint(5, 20, 100);
    ColorPoint p2 = new ColorPoint(5, 10, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p1));
  }
  
  @Test
  public void testEqualsSymetryDiffX() {
    ColorPoint p1 = new ColorPoint(1, 10, 100);
    ColorPoint p2 = new ColorPoint(5, 10, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p1));
  }
  
  @Test
  public void testEqualsSymetryDiffColor() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    ColorPoint p2 = new ColorPoint(5, 10, 200);
    ColorPoint p3 = new ColorPoint(5, 10, 300);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitive() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    ColorPoint p2 = new ColorPoint(5, 10, 100);
    ColorPoint p3 = new ColorPoint(5, 10, 100);
    
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p3));
    assertTrue(p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffX() {
    ColorPoint p1 = new ColorPoint(10, 10, 100);
    ColorPoint p2 = new ColorPoint(15, 10, 100);
    ColorPoint p3 = new ColorPoint(20, 10, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffY() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    ColorPoint p2 = new ColorPoint(5, 15, 100);
    ColorPoint p3 = new ColorPoint(5, 20, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffColor() {
    ColorPoint p1 = new ColorPoint(5, 10, 100);
    ColorPoint p2 = new ColorPoint(5, 10, 200);
    ColorPoint p3 = new ColorPoint(5, 10, 300);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }

}
