package datastructure;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

  public static void main(String[] args) {
    Map personHobies = new HashMap();
    Person ivan = new Person(35, "Ivan");
    Person dragan = new Person(35, "Dragan");
    personHobies.put(ivan, "Swimming");
    personHobies.put(dragan, "Reading books");
    System.out.println(personHobies);
  }

  private static class Person {
    private int    _age = 0;
    private String _name;

    public Person(int age, String name) {
      _age = age;
      _name = name;
    }
    
    @Override
    public int hashCode() {
      return _age;
    }
    
    @Override
    public boolean equals(Object obj) {
      return _age == ((Person) obj)._age;
    }
    
    @Override
    public String toString() {
      return _name + " age " + _age;
    }
  }
  
  

}
