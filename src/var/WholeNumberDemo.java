package var;

public class WholeNumberDemo {

  public static void main(String[] args) {
    byte kilometers = 30;
    short meters = (short) (kilometers * 1000);
    int centimeters = meters * 100;
    long milimeters = centimeters * 10L;
    
    System.out.println("Kilometers : " + kilometers);
    System.out.println("Meters : " + meters);
    System.out.println("Centimeters : " + centimeters);
    System.out.println("Milimeters : " + milimeters);
    
  }

}
