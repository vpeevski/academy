package oop.inherit.concrete;

public class ColorPoint extends Point {
  
  int color;

  public ColorPoint(int x, int y, int color) {
    super(x, y);
    this.color = color;
  }
  
  @Override
  public boolean equals(Object obj) { // equals method is not possible to be implemented correctly
    if (!(obj instanceof Point)) {
      return false;
    }
    
    if (! (obj instanceof ColorPoint)) {
      return false;
    }
    
    ColorPoint that = (ColorPoint) obj;
    
    
    return super.equals(that) && color == that.color;
  }
  
  

}
