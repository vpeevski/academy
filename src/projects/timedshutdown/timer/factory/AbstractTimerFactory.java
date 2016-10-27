package projects.timedshutdown.timer.factory;

import projects.timedshutdown.timer.ITimerFactory;



public class AbstractTimerFactory
{
  private static ITimerFactory factory = null;
  public static final String RESTART_TIMER = "Restart";
  public static final String SHUTDOWN_TIMER = "Shut down";
  public static final String HIBERNATE_TIMER = "Hibernate";
  public static final String[] OPERATIONS = { "Shut down", "Restart", "Hibernate" };
  
  public AbstractTimerFactory() {}
  
  public static ITimerFactory getInstance(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
      factory = new ShutDownTimerFactory();
      return factory;
    case 1: 
      factory = new RestartTimerFactory();
      return factory;
    case 2: 
      factory = new HibernateTimerFactory();
      return factory;
    }
    factory = new NullTimerFactory();
    return factory;
  }
  
  public static void abortAll()
  {
    factory.abortAll();
  }
}
