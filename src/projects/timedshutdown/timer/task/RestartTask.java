package projects.timedshutdown.timer.task;

import java.io.IOException;

public class RestartTask
  extends AbstractTask
{
  public RestartTask(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean, paramInt);
  }
  
  public void execute()
  {
    try
    {
      Runtime.getRuntime().exec("shutdown -r -f -t 0");
    }
    catch (IOException localIOException) {}
  }
  
  public String toString()
  {
    return "Restart";
  }
}
