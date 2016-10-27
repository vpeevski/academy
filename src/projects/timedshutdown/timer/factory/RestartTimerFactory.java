package projects.timedshutdown.timer.factory;

import projects.timedshutdown.timer.task.ITimedTask;
import projects.timedshutdown.timer.task.RestartTask;


public class RestartTimerFactory
  extends TimerFactory
{
  public RestartTimerFactory() {}
  
  public ITimedTask createTask(boolean paramBoolean, int paramInt)
  {
    return new RestartTask(paramBoolean, paramInt);
  }
}
