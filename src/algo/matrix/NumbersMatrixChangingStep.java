package algo.matrix;

import java.util.Scanner;

public class NumbersMatrixChangingStep {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in); 
    System.out.println("Enter n : ");
    int n = scanner.nextInt();
    
    for (int i = 0; i < n; i++) {
      int stepForRow = i + 1;
      int nextNumber = stepForRow;
      
      for (int j = 0; j < n; j++) {
        System.out.print(nextNumber + " ");
        nextNumber += stepForRow;
      }
      
      System.out.println();
      
    }
    
    
    
  }

}
