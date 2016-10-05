package datastructure;

import java.util.TreeSet;

public class TreeSetDemo {

  public static void main(String[] args) {

    TreeSet sortedSet = new TreeSet();
    sortedSet.add(new Person(35, "Ivan"));
    sortedSet.add(new Person(21, "Maria"));
    sortedSet.add(new Person(50, "Trifon"));
    System.out.println(sortedSet);

  }
  
private static class Person implements Comparable {
    
    private int _age;
    
    private String _name;
    
    public Person (int age, String name) {
      _age = age;
      _name = name;
    }

    @Override
    public int compareTo(Object o) {
      Person otherPerson = (Person) o;
      return _age - otherPerson._age;
    }
    
    @Override
    public String toString() {
      return "Person{name : " + _name + " age : " + _age + "}";
    }

    
    
  }

}
