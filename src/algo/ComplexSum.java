package algo;

import java.util.Scanner;

public class ComplexSum {

  public static void main(String[] args) {
    int n;
    Scanner scanner = new Scanner(System.in);

    do {
      System.out.println("Insert Positive number : ");
      n = scanner.nextInt();
    } while (n <= 0);
    
    double sum = 0;
    for (int i = 1; i <= n; i++) {
      double iFact = 1;
      double iPowI = 1;
      for (int j = 1; j <= i; j++) {
        iFact = iFact * j;
        iPowI = iPowI * i;
      }
      
      double member = iFact / iPowI;
      sum += member;
    }
    
    System.out.println("Sum is : " + sum);
  }

}
