package var;

public class DecimalNumbersDemo {
  
  public static void main(String[] args) {
    
    float fahrenheitFloat = 104.1F;
    float celsiusFloat = (fahrenheitFloat - 32) * 5 / 9;
    System.out.println("Float : " + fahrenheitFloat + "F = " + celsiusFloat + "C");
    
    double fahrenheitDouble = 104.1;
    double celsiusDouble = (fahrenheitDouble - 32) * 5 / 9;
    System.out.println("Double : " + fahrenheitDouble + "F = " + celsiusDouble + "C");
    
    
    celsiusFloat = 40.055557F;
    fahrenheitFloat = celsiusFloat*9/5 + 32;
    System.out.println("Float : " + celsiusFloat + "C = " + fahrenheitFloat + "F");
    
    celsiusDouble = 40.05555555555556;
    fahrenheitDouble = celsiusDouble*9/5 + 32;
    System.out.println("Double : " + celsiusDouble  + "C = " + fahrenheitDouble + "F");
  }

}
