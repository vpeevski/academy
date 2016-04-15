package oop.office;

public class AllWork {
  
  private Task[] tasks;
  
  private int freePlacesForTask;
  
  private int currentUnassignedTask;
  
  public AllWork () { }
  
  public void addTask (Task task) {
    if (freePlacesForTask > 0) {
      tasks[++currentUnassignedTask] = task; //TODO re-check this
      freePlacesForTask--;
    } else {
      System.out.println("Tasks pool is full! Task " + task.getName() + " can not be added !");
    }
  }

}
