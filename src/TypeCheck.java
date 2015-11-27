
public class TypeCheck {

  public static void main(String[] args) {
//    int a = 0b10000000;
    int a = 128;
    System.out.println(Integer.toBinaryString(a));
    
    float f = 0.1f;
    
    float sum = 0f;
    for (int i = 0; i <= 9; i++) {
      sum = sum + f;
    }
    System.out.println(sum);
  }
  
}
