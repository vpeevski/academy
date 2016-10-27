package projects.timedshutdown.timer.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AbortWindow
{
  private JFrame window = new JFrame("ABORT shut down");
  private boolean isAborted = false;
  private final Object ready = new Object();
  
  public AbortWindow(int paramInt, String paramString)
  {
    window.setDefaultCloseOperation(0);
    window.setLayout(new BorderLayout());
    Container localContainer = window.getContentPane();
    JLabel localJLabel1 = new JLabel("The conputer will " + paramString + " after :");
    localContainer.add(localJLabel1, "West");
    JLabel localJLabel2 = new JLabel();
    localJLabel2.setForeground(new Color(255, 0, 0));
    localContainer.add(localJLabel2, "Center");
    JLabel localJLabel3 = new JLabel(" seconds");
    localContainer.add(localJLabel3, "East");
    final AbortIntervalUpdater localAbortIntervalUpdater = new AbortIntervalUpdater(localJLabel2, paramInt);
    JPanel localJPanel = new JPanel();
    localJPanel.setLayout(new FlowLayout());
    JButton localJButton = new JButton("Abort");
    localJButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        synchronized (ready)
        {
          isAborted = true;
          window.dispose();
          ready.notify();
          localAbortIntervalUpdater.interupt();
        }
      }
    });
    localJPanel.add(localJButton);
    localContainer.add(localJPanel, "South");
    new Thread(localAbortIntervalUpdater).start();
    window.setSize(275, 100);
    window.setResizable(false);
    window.setVisible(true);
  }
  
  public boolean isAborted()
  {
    synchronized (ready)
    {
      try
      {
        ready.wait();
      }
      catch (InterruptedException localInterruptedException) {}
      return isAborted;
    }
  }
  
  private class AbortIntervalUpdater
    implements Runnable
  {
    private final JLabel abortIntervalLabel;
    private final int initialAbortInterval;
    private boolean interupted = false;
    
    private AbortIntervalUpdater(JLabel paramJLabel, int paramInt)
    {
      abortIntervalLabel = paramJLabel;
      initialAbortInterval = paramInt;
    }
    
    public void run()
    {
      int i = initialAbortInterval;
      try
      {
        while ((!interupted) && (i >= 0))
        {
          abortIntervalLabel.setText(String.valueOf("   " + i));
          Thread.sleep(1000L);
          i--;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        return;
      }
      if (!interupted)
      {
        window.dispose();
        synchronized (ready)
        {
          ready.notify();
        }
      }
    }
    
    private void interupt()
    {
      interupted = true;
    }
  }
}
