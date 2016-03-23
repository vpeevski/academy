package oop.overridable.method.in.constructor;

public abstract class Base {
  
  protected int a;
  
  public Base () {
    System.out.println("Constructing OverridableMethodInConstructor");
    initA();
  }
  
  protected void initA () { // this should be done final
    a = 5;
  }

}
