package projects.timedshutdown.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import projects.timedshutdown.timer.ITimerFactory;
import projects.timedshutdown.timer.factory.AbstractTimerFactory;


public class MainPanel
{
  private final JTextField currentTimeTextField;
  private final Container mainPane;
  private final JTextField shutDownTimeHour;
  private final JTextField shutDownTimeMin;
  private final JTextField shutDownTimeSec;
  private final JComboBox operationCombo;
  
  public MainPanel()
  {
    JFrame localJFrame = new JFrame("Timed shut down");
    localJFrame.setDefaultCloseOperation(1);
    new TimerShutDownSysTrayManager(localJFrame);
    currentTimeTextField = new JTextField();
    mainPane = localJFrame.getContentPane();
    shutDownTimeHour = new JTextField();
    shutDownTimeMin = new JTextField();
    shutDownTimeSec = new JTextField();
    shutDownTimeHour.addKeyListener(new TimeDoubleDigitListener(shutDownTimeMin, 0, 23));
    shutDownTimeMin.addKeyListener(new TimeDoubleDigitListener(shutDownTimeSec, 0, 59));
    operationCombo = new JComboBox(AbstractTimerFactory.OPERATIONS);
    BorderLayout localBorderLayout = new BorderLayout();
    localJFrame.setLayout(localBorderLayout);
    createLeftSideLabels();
    createRighSideTextFields();
    createStartButton();
    //createAbortButton();
    localJFrame.pack();
    localJFrame.setSize(300, 180);
    localJFrame.setResizable(false);
    localJFrame.setIconImage(TimerShutDownSysTrayManager.createImage("clock.jpg", "Timer shut down"));
    localJFrame.setVisible(true);
    startTimeUpdate();
  }
  
  private void startTimeUpdate()
  {
    Thread localThread = new Thread(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          MainPanel.this.updateCurrentTime();
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    });
    localThread.start();
  }
  
  private void updateCurrentTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    String str = new SimpleDateFormat("HH:mm:ss").format(localCalendar.getTime());
    currentTimeTextField.setText(str);
  }
  
  private void createLeftSideLabels()
  {
    Box localBox = Box.createVerticalBox();
    JLabel localJLabel1 = new JLabel("Operation:");
    JLabel localJLabel2 = new JLabel("Current time:");
    JLabel localJLabel3 = new JLabel("Shut down at:");
    localBox.add(Box.createVerticalStrut(11));
    localBox.add(localJLabel1);
    localBox.add(Box.createVerticalStrut(27));
    localBox.add(localJLabel2);
    localBox.add(Box.createVerticalStrut(22));
    localBox.add(localJLabel3);
    mainPane.add(localBox, "West");
  }
  
  private void createRighSideTextFields()
  {
    Box localBox1 = Box.createVerticalBox();
    localBox1.add(operationCombo);
    localBox1.add(Box.createVerticalStrut(8));
    currentTimeTextField.setEditable(false);
    currentTimeTextField.setBackground(new Color(0, 0, 0));
    currentTimeTextField.setForeground(new Color(0, 0, 250));
    currentTimeTextField.setFont(new Font("Serif", 1, 30));
    localBox1.add(currentTimeTextField);
    localBox1.add(Box.createVerticalStrut(8));
    localBox1.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
    Box localBox2 = Box.createHorizontalBox();
    localBox2.add(shutDownTimeHour);
    createTimeDelimiter(localBox2);
    localBox2.add(shutDownTimeMin);
    createTimeDelimiter(localBox2);
    localBox2.add(shutDownTimeSec);
    localBox1.add(localBox2);
    mainPane.add(localBox1, "Center");
  }
  
  private void createTimeDelimiter(Container paramContainer)
  {
    JLabel localJLabel = new JLabel(" : ");
    paramContainer.add(localJLabel);
  }
  
  private void createStartButton()
  {
    JPanel localJPanel = new JPanel();
    localJPanel.setLayout(new FlowLayout());
    JButton localJButton = new JButton();
    localJButton.setText("Start");
    localJButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent paramAnonymousActionEvent)
      {
        if ((TimeInputValidator.isTimeValueValid(shutDownTimeHour.getText(), 0, 23)) && (TimeInputValidator.isTimeValueValid(shutDownTimeMin.getText(), 0, 59)) && (TimeInputValidator.isTimeValueValid(shutDownTimeSec.getText(), 0, 59)))
        {
          int i = Integer.valueOf(shutDownTimeHour.getText()).intValue();
          int j = Integer.valueOf(shutDownTimeMin.getText()).intValue();
          int k = Integer.valueOf(shutDownTimeSec.getText()).intValue();
          ITimerFactory localITimerFactory = AbstractTimerFactory.getInstance(operationCombo.getSelectedIndex());
          localITimerFactory.createTimer(i, j, k, localITimerFactory.createTask(true, 10)).schedule();
        }
        else
        {
          JOptionPane.showMessageDialog(null, "Invalid input !");
        }
      }
    });
    localJPanel.add(localJButton);
    mainPane.add(localJPanel, "South");
  }
  
//  private void createAbortButton()
//  {
//    JPanel localJPanel = new JPanel();
//    localJPanel.setLayout(new FlowLayout());
//    JButton localJButton = new JButton();
//    localJButton.setText("Abort");
//    localJButton.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent paramAnonymousActionEvent) {
//    	  System.out.println("abort");
//      }
//    });
//    localJPanel.add(localJButton);
//    mainPane.add(localJPanel, "East");
//  }
  
  public static void main(String[] paramArrayOfString)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        new MainPanel();
      }
    });
  }
  
  private static class TimeDoubleDigitListener
    implements KeyListener
  {
    final JComponent nextFocusElement;
    final int leftLimit;
    final int rightLimit;
    
    public TimeDoubleDigitListener(JComponent paramJComponent, int paramInt1, int paramInt2)
    {
      nextFocusElement = paramJComponent;
      leftLimit = paramInt1;
      rightLimit = paramInt2;
    }
    
    public void keyPressed(KeyEvent paramKeyEvent) {}
    
    public void keyReleased(KeyEvent paramKeyEvent)
    {
      JTextField localJTextField = (JTextField)paramKeyEvent.getSource();
      String str = localJTextField.getText();
      if ((str.length() == 2) && (TimeInputValidator.isTimeValueValid(str, leftLimit, rightLimit))) {
        nextFocusElement.grabFocus();
      }
    }
    
    public void keyTyped(KeyEvent paramKeyEvent) {}
  }
}
