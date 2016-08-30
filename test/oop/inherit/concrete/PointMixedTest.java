package oop.inherit.concrete;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointMixedTest {

  @Test
  public void testEqualsReflexive() {
    Point p1 = new ColorPoint(5, 10, 100);
    
    assertTrue(p1.equals(p1));
  }
  
  @Test
  public void testEqualsNotNull() {
    Point p1 = new ColorPoint(5, 10, 100);
    
    assertTrue(!p1.equals(null));
  }

  @Test
  public void testEqualsSymetry() {
    Point p1 = new ColorPoint(5, 10, 100);
    Point p2 = new Point(5, 10);
    
    assertTrue(p2.equals(p1));
    assertTrue(p1.equals(p2)); // design problem ColorPoint should not inherit from Point
  }
  
  @Test
  public void testEqualsSymetryDiffY() {
    Point p1 = new ColorPoint(5, 20, 100);
    Point p2 = new ColorPoint(5, 10, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p1));
  }
  
  @Test
  public void testEqualsSymetryDiffX() {
    Point p1 = new ColorPoint(1, 10, 100);
    Point p2 = new ColorPoint(5, 10, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p1));
  }
  
  @Test
  public void testEqualsSymetryDiffColor() {
    Point p1 = new ColorPoint(5, 10, 100);
    Point p2 = new ColorPoint(5, 10, 200);
    Point p3 = new ColorPoint(5, 10, 300);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitive() {
    Point p1 = new ColorPoint(5, 10, 100);
    Point p2 = new ColorPoint(5, 10, 100);
    Point p3 = new ColorPoint(5, 10, 100);
    
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p3));
    assertTrue(p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffX() {
    Point p1 = new ColorPoint(10, 10, 100);
    Point p2 = new ColorPoint(15, 10, 100);
    Point p3 = new ColorPoint(20, 10, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffY() {
    Point p1 = new ColorPoint(5, 10, 100);
    Point p2 = new ColorPoint(5, 15, 100);
    Point p3 = new ColorPoint(5, 20, 100);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffColor() {
    Point p1 = new ColorPoint(5, 10, 100);
    Point p2 = new ColorPoint(5, 10, 200);
    Point p3 = new ColorPoint(5, 10, 300);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }

}
