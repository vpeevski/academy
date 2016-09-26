package datastructure;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

  public static void main(String args[]) { 
    int count[] = {34, 22,10,60,30,22};
    Set<Integer> set = new HashSet<Integer>();
    try {
       for(int i = 0; i < 5; i++) {
          set.add(count[i]);
       }
       System.out.println(set);

       TreeSet<Integer> sortedSet = new TreeSet<Integer>(set);
       sortedSet.addAll(set);
       System.out.println("The sorted list is:");
       System.out.println(sortedSet);

       System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
       System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
    }
    catch(Exception e) {}
    
    sortSetComparableDemo();
 }
  
  private static void sortSetComparableDemo () {
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
