package algo.arrays;

public class LongestIncSequence {
  
  private static int[] _inputArray = {1, 2, 3, 2, 4, 5, 6, 7, 8, 9, 10, 1, 4, 9, 3};
  
  public static void main(String[] args) {
//    int longestSeqLen = longestSeqLenght();
//    
//    System.out.println("Longest sequence has lenght: " + longestSeqLen);
    
    int[] longestSeq = findLongestSeq();
    
    System.out.println("Longest sequence has lenght: " + longestSeq.length);
    
    for (int i = 0; i < longestSeq.length; i++) {
      System.out.print(longestSeq[i] + " ");
    }
    
    
  }

//  private static int longestSeqLenght() {
//    int longestIncSeqLen = 1;
//    int currentLongest = 1;
//    
//    for(int i = 1; i < _inputArray.length; i++) {
//      if (_inputArray[i] > _inputArray[i - 1]) {
//        currentLongest++;
//      } else if (currentLongest > longestIncSeqLen){
//        longestIncSeqLen = currentLongest;
//        currentLongest = 1;
//      }
//    }
//    
//    if (currentLongest > longestIncSeqLen) {
//      longestIncSeqLen = currentLongest;
//    }
//    
//    return longestIncSeqLen;
//  }
  
  private static int[] findLongestSeq () {
    int startIndex = 0;
    int longestIncSeqLen = 1;
    int currentLongest = 1;
    
    for(int i = 1; i < _inputArray.length; i++) {
      if (_inputArray[i] > _inputArray[i - 1]) {
        currentLongest++;
      } else if (currentLongest > longestIncSeqLen) {
        longestIncSeqLen = currentLongest;
        startIndex = i - currentLongest;
        currentLongest = 1;
        
      }
    }
    
    if (currentLongest > longestIncSeqLen) {
      longestIncSeqLen = currentLongest;
      startIndex = _inputArray.length - currentLongest;
    }
    
    
    int longestSeq[] = new int[longestIncSeqLen];
    
    for(int i = 0; i < longestIncSeqLen; i++) {
      longestSeq[i] = _inputArray[i + startIndex];
    }
    
    return longestSeq;
  }

}
