package projects.timedshutdown.timer.factory;

import projects.timedshutdown.timer.task.ITimedTask;
import projects.timedshutdown.timer.task.ShutDownTask;


public class ShutDownTimerFactory
  extends TimerFactory
{
  public ShutDownTimerFactory() {}
  
  public ITimedTask createTask(boolean paramBoolean, int paramInt)
  {
    return new ShutDownTask(paramBoolean, paramInt);
  }
}
