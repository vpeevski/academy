package sorting;

import java.util.Arrays;

import sorting.time.TimeInterceptor;
import sorting.time.Timer;

public abstract class AbstractSortWithTimer extends AbstractSort {
  
  private final TimeInterceptor _timeInterceptor;
  
  public AbstractSortWithTimer (TimeInterceptor timeInterceptor) {
    _timeInterceptor = timeInterceptor;
  }
  
  public AbstractSortWithTimer () {
    _timeInterceptor = new Timer();
  }

  public long sortForTime (int[] inputArray) {
    _timeInterceptor.startTime();
    sort(inputArray);
    _timeInterceptor.endTime();
    long time = _timeInterceptor.executingTime();
    System.out.println("Done for : " + time + " msec.");
    System.out.println("Sorted: " + Arrays.toString(inputArray));
    return time;
  }

}
