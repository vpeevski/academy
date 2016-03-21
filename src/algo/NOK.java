package algo;

import util.MathUtil;

public class NOK {
  
  public static long nokNaive (int a, int b) {
    int bigger = MathUtil.max(a, b);
    long multi = a * b;
    for (long i = bigger; i <= multi; i++) {
      if (i % a == 0 && i % b == 0) {
        return i;
      }
    }
    
    return multi;
  }
  
  public static long nok (int a, int b) {
    return a * (b / NOD.nod(a, b));
  }
  
  public static long nokMany (int... numbers) {
    if (numbers.length == 0) throw new IllegalArgumentException("NOK operation is not definet for empty value : " + numbers); 
    if (numbers.length == 1) return numbers[0];
    
    long result = 0;
    for (int i = 0; i < numbers.length - 1; i++) {
        if (result == 0) {
            result = nok (numbers[0], numbers[1]);
        } else {
            result = nok(result, numbers[i + 1]);
        }
    }
    
    return result;
  }
  
  private static long nok (long a, int b) {
    return a * (b / NOD.nod(a, b));
  }

}
