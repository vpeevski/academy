package projects.timedshutdown.timer.task;

import java.util.TimerTask;

public abstract class AbstractTask
  implements ITimedTask
{
  protected final boolean abortable;
  protected final int abortAlertSeconds;
  
  public AbstractTask(boolean paramBoolean, int paramInt)
  {
    abortable = paramBoolean;
    abortAlertSeconds = paramInt;
  }
  
  public TimerTask timedTask()
  {
    return new TimerTask()
    {
      public void run()
      {
        if (!AbstractTask.this.isAborted()) {
          execute();
        }
      }
    };
  }
  
  private boolean isAborted()
  {
    if (!abortable) {
      return false;
    }
    return abortWindowAnswer();
  }
  
  private boolean abortWindowAnswer()
  {
    return new AbortWindow(abortAlertSeconds, toString()).isAborted();
  }
  
  protected abstract void execute();
}
