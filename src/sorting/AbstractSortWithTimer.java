package sorting;

import java.util.Arrays;

import org.apache.log4j.Logger;

import sorting.time.TimeInterceptor;
import sorting.time.Timer;

public abstract class AbstractSortWithTimer extends AbstractSort {
  
  private final TimeInterceptor _timeInterceptor;
  
  private Logger _logger = Logger.getLogger(this.getClass().getName());
  
  public AbstractSortWithTimer (TimeInterceptor timeInterceptor) {
    _timeInterceptor = timeInterceptor;
  }
  
  public AbstractSortWithTimer () {
    _timeInterceptor = new Timer();
  }

  public long sortForTime (int[] inputArray) {
	 int[] clonedInput = inputArray.clone();
    _timeInterceptor.startTime();
    sort(inputArray);
    _timeInterceptor.endTime();
    long time = _timeInterceptor.executingTime();
    _logger.debug("Done for : " + time + " msec.");
    _logger.debug("Input array : " + Arrays.toString(clonedInput));
    _logger.debug("Sorted: " + Arrays.toString(inputArray));
    return time;
  }

}
