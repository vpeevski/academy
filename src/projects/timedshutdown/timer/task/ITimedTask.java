package projects.timedshutdown.timer.task;

import java.util.TimerTask;

public abstract interface ITimedTask
{
  public abstract TimerTask timedTask();
}
