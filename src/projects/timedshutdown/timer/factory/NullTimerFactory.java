package projects.timedshutdown.timer.factory;

import projects.timedshutdown.timer.task.ITimedTask;
import projects.timedshutdown.timer.task.NullTask;


public class NullTimerFactory
  extends TimerFactory
{
  public NullTimerFactory() {}
  
  public ITimedTask createTask(boolean paramBoolean, int paramInt)
  {
    return new NullTask(paramBoolean, paramInt);
  }
}
