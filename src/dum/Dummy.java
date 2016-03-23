package dum;

public class Dummy {
  
  public static void main(String[] args) {
    
    float floatValue =  0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f;
    
    double doubleValue =  3.1111111111111111111111111111111111111111;
    
    
    System.out.println(0.0 / 0.0);
//    
//    System.out.println();
//    
//    System.out.println("Bouble value: " + doubleValue);
//    
//    System.out.println("min value: " + Float.MIN_VALUE);
//    
//    System.out.println("min normal value: " + Float.MIN_NORMAL);
    
    
    double x1 = 0.1;
    double x2 = 0.1 + 0.1 + 0.1;
    
    System.out.println(Integer.toBinaryString(Float.floatToRawIntBits(Float.MIN_VALUE)));
//    System.out.println(Long.toBinaryString(Double.doubleToLongBits(x1)));
//    System.out.println(x2);
//    System.out.println(x1 == x2);

    double z1 = 0.5;
    double z2 = 0.1 + 0.1 + 0.1;
    //System.out.println(z1 == z2);
  }

}
