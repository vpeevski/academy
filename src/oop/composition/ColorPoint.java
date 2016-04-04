package oop.composition;

import oop.inherit.concrete.Point;

public class ColorPoint {
  
  private Point point;
  
  public ColorPoint(int x, int y, int color) {
    point = new Point(x, y);
    this.color = color;
  }
  
  int color;
  
  @Override
  public boolean equals(Object obj) { // equals method is implemented correctly for composition
    if (! (obj instanceof ColorPoint)) {
      return false;
    }
    
    ColorPoint that = (ColorPoint) obj;
    
    
    return point.getX() ==  that.point.getX() &&  point.getY() ==  that.point.getY() && color == that.color;
  }
  
}
