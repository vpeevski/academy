package var;

public class DeclareInitScope {
  
  public static void main(String[] args) {
    int number;
//    System.out.println(number); // variable is not initialized 
    number = 5;
    System.out.println(number);
    
    int otherNumber = 10;
    System.out.println(otherNumber);
    
    { // start new visibility block
      int thirdNumber = 15;
      System.out.println(thirdNumber);
    }
    
//    System.out.println(thirdNumber); //thirdNumber is not visible
  }
  

}
