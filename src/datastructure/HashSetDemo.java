package datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetDemo {

  public static void main(String args[]) { 
    Integer count[] = {34, 22,10,60,30,22};
    Set<Integer> set = new HashSet<Integer>();
   
    try {
       set.addAll(Arrays.asList(count));
       TreeSet<Integer> sortedSet = new TreeSet<Integer>(set);
       sortedSet.addAll(set);
       System.out.println("The sorted list is:");
       System.out.println(sortedSet);

       System.out.println("The First element of the set is: "+ (Integer)sortedSet.first());
       System.out.println("The last element of the set is: "+ (Integer)sortedSet.last());
    } catch(Exception e) {}
    
    
 }

}
