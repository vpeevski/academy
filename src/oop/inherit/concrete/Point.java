package oop.inherit.concrete;

public class Point {
  private int x;
  private int y;
  
  public Point (int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (! (obj instanceof Point)) {
      return false;
    }
    
    Point that = (Point) obj;
    
    if(that.x == x && that.y == y) {
      return true;
    }
    
    return false;
  }
  

}
