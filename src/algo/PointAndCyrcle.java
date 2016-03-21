package algo;

public class PointAndCyrcle {

  public boolean isPointInCyrcle(int rx, int ry, int r, int px, int py) {

    int xOffset = px - rx;

    int yOffset = py - ry;

    double pr = Math.sqrt(xOffset * xOffset + yOffset * yOffset);

    return pr <= r;
  }
}
