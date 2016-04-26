package algo;

import java.util.Scanner;

public class Factoriel {

  public static void main(String[] args) {
    
    int n;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Enter possitive number :");
      n = scanner.nextInt();
    } while (n < 1);
    
    
    long fact = 1;
    
    for(int i = 2; i <=n; i++ ) {
      fact = fact * i;
    }
    
    System.out.println(n + "! = " + fact);
  }

}
