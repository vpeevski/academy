package algo;

import java.util.Scanner;

public class BreakDemo {

  public static void main(String[] args) {

    int n;
    Scanner scanner = new Scanner(System.in);
    
    do {
      System.out.print("Enter numer between 0 and 10 : ");
      n = scanner.nextInt();
    } while (n < 0 || n > 10);
    
    for (int i = 0; i < 10 && i != n; i++) {
//      if (i == n) {
//        break;
//      }
      System.out.println(i);
    }

  }

}
