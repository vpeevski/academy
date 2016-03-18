package algo;

/**
 * 
 * Uses Evklid algorithm to find GCD
 * 
 * @author vpeevski
 *
 */
public class NOD {

  public int nod(int a, int b) {

    int bigger = a;
    int less = a;

    if (b > bigger) {
      bigger = b;
    } else {
      less = b;
    }

    int rest = bigger % less;
    
    while (rest > 0) {
      bigger = less;
      less = rest;
      rest = bigger % less;
    }

    System.out.println("NOD of " + a + " and " + b + " is: " + less);

    return less;
  }

  public int nodDiv(int a, int b) {
    System.out.print("NOD of " + a + " and " + b + " is: "); // mention this output is in the beginning

    while (a != b) {
      if (a > b) {
        a = a - b;
      } else {
        b = b - a;
      }
    }

    System.out.print(a);

    return a;
  }

  public static void main(String[] args) {
    NOD nod = new NOD();
    nod.nod(36, 84);
    nod.nodDiv(12, 8);
  }

}
