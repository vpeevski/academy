package projects.timedshutdown.timer.task;

import java.io.IOException;

public class ShutDownTask
  extends AbstractTask
{
  public ShutDownTask(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean, paramInt);
  }
  
  public void execute()
  {
    try
    {
      Runtime.getRuntime().exec("shutdown -s -f -t 0");
    }
    catch (IOException localIOException) {}
  }
  
  public String toString()
  {
    return "Shut Down";
  }
}
