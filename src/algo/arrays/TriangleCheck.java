package algo.arrays;

public class TriangleCheck {

  public static boolean isTriangle(int[] array) {
    if (array == null || array.length < 3) { return false; }

    int changesNum = 0;
    boolean moveUp = array[1] >= array[0];
    for (int i = 2; i < array.length; i++) {
      if (isDirectionChanged(moveUp, array[i] > array[i - 1])) {
        changesNum++;
        moveUp = !moveUp;
      }
      
      if (changesNum > 1) {
        return false;
      }
    }

    return changesNum == 1;
  }

  private static boolean isDirectionChanged(boolean isMovingUp, boolean isBigger) {
    return isMovingUp != isBigger;
  }

}
