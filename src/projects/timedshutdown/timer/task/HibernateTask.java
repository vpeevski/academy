package projects.timedshutdown.timer.task;

import java.util.TimerTask;
import javax.swing.JOptionPane;

public class HibernateTask
  extends AbstractTask
{
  public HibernateTask(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean, paramInt);
  }
  
  public void execute()
  {
    JOptionPane.showMessageDialog(null, "Hibernate task not supported yet !");
  }
  
  protected String taskName()
  {
    return "hibernate";
  }
  
  public TimerTask getTask()
  {
    return null;
  }
  
  public String toString()
  {
    return "Hibernate";
  }
}
