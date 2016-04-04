package var;

public class CharDemo {
  
  public static void main(String[] args) {
    char c1 = 'A';
    char c2 = 'B';
    System.out.println("c1 = " + c1);
    System.out.println("c1 code is " + (int) c1);
    System.out.println("c2 = " + c2);
    System.out.println("c2 code is " + (int) c2);
    System.out.println("c1 + c2 = " + (c1 + c2)); //prints integer result
    
    System.out.println("c1 == c2 = " + (c1 == c2)); // false
    System.out.println("c1 > c2 = " + (c1 > c2)); // false
    System.out.println("c1 < c2 = " + (c1 < c2)); // true
    
    c1++;
    System.out.println("c1 = " + c1);
    c1 = (char) (c1 + 1);
    System.out.println("c1 = " + c1);
    System.out.println("c1 == c2 = " + (c1 == c2)); // true
    
    char c4 = 100;
    System.out.println("c4 = " + c4); //prints char equivalent 
    
    
    
    
    
  }

}
