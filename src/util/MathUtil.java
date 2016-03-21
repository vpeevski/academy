package util;

public final class MathUtil {

  private MathUtil() {};

  public static int max(int a, int b) {
    int max = a;
    if (b > max) {
      max = b;
    }

    return max;
  }

  public static int min(int a, int b) {
    int min = a;
    if (b < min) {
      min = b;
    }

    return min;
  }

  public static long max(long a, long b) {
    long max = a;
    if (b > max) {
      max = b;
    }

    return max;
  }

  public static long min(long a, long b) {
    long min = a;
    if (b < min) {
      min = b;
    }

    return min;
  }
  
  public static long max(long a, int b) {
    long max = a;
    if (b > max) {
      max = b;
    }

    return max;
  }

  public static long min(long a, int b) {
    long min = a;
    if (b < min) {
      min = b;
    }

    return min;
  }

}
