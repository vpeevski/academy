package algo;

public class BreakContinuteDemo {

  public static void main(String[] args) {
    //    int i;
    //    for(i = 0; i < 10; i++) {
    //      if (i == 7) {
    //        break;
    //      }
    //      System.out.println(i);
    //    }
    //    
    //    System.out.println("After first cycle i = " + i);
    //    
    //    for(i = 0; i < 10; i++) {
    //      if (i == 7) {
    //        continue;
    //      }
    //      System.out.println(i);
    //    }
    //    
    //    System.out.println("After second cycle i = " + i);

    //break and continue work for inner cycle

    int i;
    for (i = 0; i < 10; i++) {
      int j;
      for (j = 0; j < 10; j++) {
        break;
      }

      System.out.println(j);
    }

    System.out.println(i);

  }

}
