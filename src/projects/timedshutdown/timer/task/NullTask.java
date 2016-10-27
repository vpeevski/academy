package projects.timedshutdown.timer.task;

public class NullTask
  extends AbstractTask
{
  public NullTask(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean, paramInt);
  }
  
  public void execute() {}
  
  protected String taskName()
  {
    return "";
  }
}
