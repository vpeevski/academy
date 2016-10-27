package projects.timedshutdown.timer.factory;

import projects.timedshutdown.timer.ITimer;
import projects.timedshutdown.timer.ITimerFactory;
import projects.timedshutdown.timer.TimerImpl;
import projects.timedshutdown.timer.task.ITimedTask;



public abstract class TimerFactory
  implements ITimerFactory
{
  private ITimer timer = null;
  
  public TimerFactory() {}
  
  public void abortAll()
  {
    timer.cancel();
  }
  
  public ITimer createTimer(int paramInt1, int paramInt2, int paramInt3, ITimedTask paramITimedTask)
  {
    if (timer == null) {
      timer = new TimerImpl(paramInt1, paramInt2, paramInt3, paramITimedTask);
    }
    return timer;
  }
}
