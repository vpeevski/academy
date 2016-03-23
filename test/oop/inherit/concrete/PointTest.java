package oop.inherit.concrete;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {
  
  @Test
  public void testEqualsReflexive() {
    Point p1 = new Point(5, 10);
    
    assertTrue(p1.equals(p1));
  }
  
  @Test
  public void testEqualsNotNull() {
    Point p1 = new Point(5, 10);
    
    assertTrue(!p1.equals(null));
  }

  @Test
  public void testEqualsSymetry() {
    Point p1 = new Point(5, 10);
    Point p2 = new Point(5, 10);
    
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p1));
  }
  
  @Test
  public void testEqualsSymetryDiffY() {
    Point p1 = new Point(5, 20);
    Point p2 = new Point(5, 10);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p1));
  }
  
  @Test
  public void testEqualsSymetryDiffX() {
    Point p1 = new Point(1, 10);
    Point p2 = new Point(5, 10);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p1));
  }
  
  @Test
  public void testEqualsTransitive() {
    Point p1 = new Point(5, 10);
    Point p2 = new Point(5, 10);
    Point p3 = new Point(5, 10);
    
    assertTrue(p1.equals(p2));
    assertTrue(p2.equals(p3));
    assertTrue(p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffX() {
    Point p1 = new Point(10, 10);
    Point p2 = new Point(15, 10);
    Point p3 = new Point(20, 10);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }
  
  @Test
  public void testEqualsTransitiveDiffY() {
    Point p1 = new Point(5, 10);
    Point p2 = new Point(5, 15);
    Point p3 = new Point(5, 20);
    
    assertTrue(!p1.equals(p2));
    assertTrue(!p2.equals(p3));
    assertTrue(!p1.equals(p3));
  }

}
