package oop.office;

public class Employee {
  
  private String name;
  
  private Task currentTask;
  
  private int hoursLeft;
  
  public Employee (String name) {
    this.name = name;
    this.hoursLeft = 8;
  }
  
  public String getName () {
    return name;
  }
  
  private void setName (String name) {
    if (name != null && name != "") {
      this.name = name;
    } else {
      System.out.println(name + " is not valid for Employee name !");
    }
  }

  public Task getCurrentTask() {
    return currentTask;
  }

  public void setCurrentTask(Task currentTask) {
    this.currentTask = currentTask;
  }

  public int getHoursLeft() {
    return hoursLeft;
  }

  public void setHoursLeft(int hoursLeft) {
    if (hoursLeft > 0) {
      this.hoursLeft = hoursLeft;
    } else {
      System.out.println(hoursLeft + " is not valid for Employee working time !");
    }
  }
  
  public void work () {
    if (currentTask != null) {
      if (hoursLeft >= currentTask.getWorkingHours()) {
        hoursLeft = hoursLeft - currentTask.getWorkingHours();
        currentTask.setWorkingHours(0);
      } else {
        hoursLeft = 0;
        currentTask.setWorkingHours(currentTask.getWorkingHours() - hoursLeft);
      }
      
      showReport();
    } else {
      System.out.println("No current task available !");
    }
  }
  
  public void showReport () {
    System.out.println("Employee " + name + " worked on task - " + currentTask.getName() + ". " + name + " has " + hoursLeft + " working hours left for today.");
    System.out.println(" Task " + currentTask.getName() + " has " + currentTask.getWorkingHours() + " hours left to be done!");
  }

}
