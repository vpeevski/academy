package oop;

public class Concrete extends OverridableMethodInConstructor {
  
  private int c;
  
  public Concrete (int c) {
    System.out.println("Constructing Concrete");
    this.c = c;
  }
  
  @Override
  protected void initA() {
    super.initA();
    System.out.println("Using Concrete : " + c); // c is not yet initialized and is 0
  }
  
  public static void main(String[] args) {
    Concrete c = new Concrete(10);
  }

}
