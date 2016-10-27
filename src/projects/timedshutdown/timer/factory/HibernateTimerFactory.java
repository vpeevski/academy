package projects.timedshutdown.timer.factory;

import projects.timedshutdown.timer.task.HibernateTask;
import projects.timedshutdown.timer.task.ITimedTask;

public class HibernateTimerFactory
  extends TimerFactory
{
  public HibernateTimerFactory() {}
  
  public ITimedTask createTask(boolean paramBoolean, int paramInt)
  {
    return new HibernateTask(paramBoolean, paramInt);
  }
}
