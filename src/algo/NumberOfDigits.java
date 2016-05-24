package algo;

public class NumberOfDigits {
  
  public static int calculate (int number) {
    int digitCount = 0;
    
    while (number != 0) {
      number = number / 10;
      digitCount++;
    }
    
    return digitCount;
    
  }

}
