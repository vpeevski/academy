package projects.timedshutdown.timer;

import projects.timedshutdown.timer.task.ITimedTask;

public abstract interface ITimerFactory
{
  public abstract ITimedTask createTask(boolean paramBoolean, int paramInt);
  
  public abstract ITimer createTimer(int paramInt1, int paramInt2, int paramInt3, ITimedTask paramITimedTask);
  
  public abstract void abortAll();
}
