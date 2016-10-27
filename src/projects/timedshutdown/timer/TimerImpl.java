package projects.timedshutdown.timer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projects.timedshutdown.timer.task.ITimedTask;

public final class TimerImpl
  implements ITimer
{
  protected final Timer timer = new Timer();
  private int executeHour;
  private int executeMin;
  private int executeSec;
  private ITimedTask task;
  
  public TimerImpl(int paramInt1, int paramInt2, int paramInt3, ITimedTask paramITimedTask)
  {
    executeHour = paramInt1;
    executeMin = paramInt2;
    executeSec = paramInt3;
    task = paramITimedTask;
  }
  
  public void schedule()
  {
    int i = calculateInSeconds(executeHour, executeMin, executeSec);
    timer.schedule(task.timedTask(), i * 1000);
    showInitialMessage(i);
  }
  
  private void showInitialMessage(int paramInt)
  {
    final JFrame localJFrame = new JFrame(task + " started");
    localJFrame.setDefaultCloseOperation(2);
    JLabel localJLabel = new JLabel("The computer will " + task + " after : " + formatDuration(paramInt));
    localJFrame.setLayout(new BorderLayout());
    localJFrame.getContentPane().add(localJLabel, "Center");
    JPanel localJPanel = new JPanel();
    localJPanel.setLayout(new FlowLayout());
    JButton localJButton = new JButton("OK");
    localJButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        localJFrame.dispose();
      }
    });
    localJPanel.add(localJButton);
    localJFrame.getContentPane().add(localJPanel, "South");
    localJFrame.pack();
    localJFrame.setResizable(false);
    localJFrame.setVisible(true);
  }
  
  private String formatDuration(int paramInt)
  {
    int i = paramInt / 3600;
    int j = paramInt % 3600 / 60;
    int k = paramInt % 3600 % 60;
    return i + " hours " + j + " minutes " + k + " seconds !";
  }
  
  private int calculateInSeconds(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Calendar.getInstance().get(11);
    int j = Calendar.getInstance().get(12);
    int k = Calendar.getInstance().get(13);
    if ((paramInt1 < i) || ((paramInt1 == i) && (paramInt2 < j)) || ((paramInt1 == i) && (paramInt2 == j) && (paramInt3 < k))) {
      paramInt1 += 24;
    }
    return (paramInt1 - i) * 60 * 60 + (paramInt2 - j) * 60 + (paramInt3 - k);
  }
  
  public void cancel()
  {
    timer.cancel();
  }
}
