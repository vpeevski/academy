package oop;

public abstract class OverridableMethodInConstructor {
  
  protected int a;
  
  public OverridableMethodInConstructor () {
    System.out.println("Constructing OverridableMethodInConstructor");
    initA();
  }
  
  protected void initA () { // this should be done final
    a = 5;
  }

}
