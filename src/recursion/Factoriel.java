package recursion;


public final class Factoriel {
  
  private Factoriel (){}
  
  public static long factorielRec (int number) {
    
    if (number <= 0) {
      throw new IllegalArgumentException("Factoriel can not be defined for non Natural numbers: " + number);
    }
    
    if(number == 1) {
      return 1;
    }
    
    return Math.multiplyExact(number, factorielRec(number - 1));
  }

}
