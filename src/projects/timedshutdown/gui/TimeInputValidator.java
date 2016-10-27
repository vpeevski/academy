package projects.timedshutdown.gui;

public class TimeInputValidator
{
  public TimeInputValidator() {}
  
  protected static boolean isTimeValueValid(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    try
    {
      int i = Integer.parseInt(paramString);
      if ((paramInt1 <= i) && (i <= paramInt2)) {
        bool = true;
      }
    }
    catch (NumberFormatException localNumberFormatException) {}
    return bool;
  }
}
