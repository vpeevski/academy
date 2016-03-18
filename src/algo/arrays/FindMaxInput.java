package algo.arrays;

import java.util.Scanner;

/**
 * 
 * Task: Insert 7 numbers in [-100; 100] and then print the max number of the input 
 * 
 * 
 * @author vpeevski
 *
 */
public class FindMaxInput {
  
  private static final int inputCount = 7;
  
  private static final int minValue = -100;
  
  private static final int maxValue = 100;
  
  public static void main(String[] args) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(System.in);
      int inputCounter = 0;
      int max = Integer.MIN_VALUE;
      while (inputCounter < inputCount) {
        System.out.println("Please insert number in range [-100, 100]" + " (" + (inputCount - inputCounter) + ") left :");
        String nextNumber = scanner.next();
        if (isNumber(nextNumber)) {
          int nextNumberInt = Integer.parseInt(nextNumber);
          if (isInRange(nextNumberInt, minValue, maxValue)) {
            if (nextNumberInt > max) {
              max = nextNumberInt;
            }
            inputCounter++;
          }
          else {
            System.out.println(nextNumber + " is not a in range !");
          }
        } else {
          System.out.println(nextNumber + " is not a number !");
        }
      }
      
      System.out.println("Max is: " + max);
    } finally {
      if (scanner != null) {
        scanner.close();
      }
    }
  }
  
  private static boolean isInRange(int nextNumberInt, int min, int max) {
    return min <= nextNumberInt && nextNumberInt <= max ;
  }

  private static boolean isNumber (String input) {
    try {
      Integer.parseInt(input);
    } catch (NumberFormatException nfe) {
      return false;
    }
    
    return true;
  }

}
