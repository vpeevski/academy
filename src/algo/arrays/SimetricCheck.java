package algo.arrays;

public class SimetricCheck {

  public static boolean isSimetric(int[] array) {
    boolean isSimetric = true;

    for (int i = 0; i < array.length && isSimetric; i++) {
      if (array[i] != array[array.length - 1 - i]) {
        isSimetric = false;
      }
    }

    return isSimetric;
  }

}
