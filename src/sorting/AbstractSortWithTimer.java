package sorting;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sorting.time.TimeInterceptor;
import sorting.time.Timer;

public abstract class AbstractSortWithTimer extends AbstractSort {
  
  private final TimeInterceptor _timeInterceptor;
  
  private Logger _logger = LoggerFactory.getLogger(this.getClass());
  
  public AbstractSortWithTimer (TimeInterceptor timeInterceptor) {
    _timeInterceptor = timeInterceptor;
  }
  
  public AbstractSortWithTimer () {
    _timeInterceptor = new Timer();
  }

  public <T extends Comparable>long sortForTime (T[] inputArray) {
	 T[] clonedInput = inputArray.clone();
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
