package algo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class finds all lists of indexes of duplicate values in an input array.
 * 
 * @author vpeevski
 *
 */
public class FindDuplicateArrValues {
  
  private static int[] _inputArray = {1, 5, 9, 2, 7, 8, 5, 7, 5, 1};

  public static void main(String[] args) {
    FindDuplicateArrValues dupFinder = new FindDuplicateArrValues();
    //Map<Integer, List> dupIndexes = dupFinder.findAllDuplicationsSingleLoop(_inputArray);
    Map<Integer, List> dupIndexes = dupFinder.findAllDuplications(_inputArray);
    dupFinder.printDupOnly(dupIndexes);
  }

//  private void printDup(Map<Integer, List> dupIndexes) {
//    Set<Integer> duplicatedValues = dupIndexes.keySet();
//    for (Integer dupValue : duplicatedValues) {
//      List dupList = dupIndexes.get(dupValue);
//      for (int i = 0; i < dupList.size(); i++) {
//        Integer dupIndex = (Integer) dupList.get(i);
//        System.out.print(dupIndex);
//        if (i < dupList.size() - 1) {
//          System.out.print(" , ");
//        }
//        
//      }
//      
//      System.out.println("; ");
//    }
//    
//  }

  private List findDuplication(int arr[], int startPos) {
    List duplicateIndexes = new ArrayList();
    for (int i = startPos + 1; i < arr.length; i++) {
      if (arr[startPos] == arr[i]) {
        if (duplicateIndexes.isEmpty()) {
          duplicateIndexes.add(startPos);
        }
        duplicateIndexes.add(i);
      }
    }
    return duplicateIndexes;
  }
  
  public Map<Integer, List> findAllDuplications (int arr[]) {
    Map<Integer, List> duplications = new HashMap();
    for (int i = 0; i < arr.length; i++) {
    	if (!duplications.containsKey(arr[i])) {
    		List duplicationsForI = findDuplication(arr, i);
    		if (!duplicationsForI.isEmpty()) { 
    			duplications.put(arr[i], duplicationsForI);
    		}
    	}
      
    }
    
    return duplications;
  }
  
  public Map<Integer, List> findAllDuplicationsSingleLoop (int arr[]) {
    Map<Integer, List> duplications = new HashMap();
    for (int i = 0; i < arr.length; i++) {
      if (duplications.containsKey(arr[i]) ) {
        List dupIndexesForI =  duplications.get(arr[i]);
        dupIndexesForI.add(i);
      } else {
        List duplicateIndexes = new ArrayList<>();
        duplicateIndexes.add(i);
        duplications.put(arr[i], duplicateIndexes);
      }
    }
    
    return duplications;
  }
  
  private void printDupOnly(Map<Integer, List> dupIndexes) {
    Set<Integer> duplicatedValues = dupIndexes.keySet();
    for (Integer dupValue : duplicatedValues) {
      List dupList = dupIndexes.get(dupValue);
      if (dupList.size() > 1) {
    	System.out.print(dupValue + " -> ");
        for (int i = 0; i < dupList.size(); i++) {
          Integer dupIndex = (Integer) dupList.get(i);
          System.out.print(dupIndex);
          if (i < dupList.size() - 1) {
            System.out.print(" , ");
          }
          
        }
        
        System.out.println("; ");
      }
      
      
    }
    
  }

}
