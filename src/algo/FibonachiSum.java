package algo;

import java.util.Scanner;

public class FibonachiSum {
  
  public static void main(String[] args) {
    
    int n;
    Scanner scanner = new Scanner(System.in);
    do {
      System.out.println("Enter number bigger than 3 : ");
      n = scanner.nextInt();
    } while (n < 3);
    
    int prev = 0;
    int curr = 1;
    int sum = prev + curr;
    
    for (int i = 3; i <= n; i++) {
      int temp = curr;
      curr = curr + prev;
      prev = temp;
      sum += curr;
      
    }
    
    System.out.println(sum);
  }

}
