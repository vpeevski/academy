package projects.timedshutdown.timer;

public abstract interface ITimer
{
  public abstract void schedule();
  
  public abstract void cancel();
}
