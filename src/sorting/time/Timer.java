package sorting.time;

public final class Timer implements TimeInterceptor {

  private long _startTime;
  private long _endTime;

  @Override
  public long startTime() {
    _startTime = System.currentTimeMillis();
    return _startTime;
  }

  @Override
  public long endTime() {
    _endTime = System.currentTimeMillis();
    return _endTime;
  }

  @Override
  public long executingTime() {
    return _endTime - _startTime;
  }

}
