package algo.arrays;

public class SimetricCheck {

  public static boolean isSimetric(int[] array) {
    boolean isSimetric = true;

    for (int i = 0; i < array.length / 2 && isSimetric; i++) {
      if (array[i] != array[array.length - 1 - i]) {
        isSimetric = false;
      }
    }

    return isSimetric;
  }
  
  public static boolean isSimetricWithBreak (int[] array) {
	    boolean isSimetric = true;

	    for (int i = 0; i < array.length / 2; i++) {
	      if (array[i] != array[array.length - 1 - i]) {
	        isSimetric = false;
	        break;
	      }
	    }

	    return isSimetric;
	  }

}
