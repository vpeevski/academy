package oop.office;

public class Task {

  private String name;

  private int    workingHours;

  public Task(String name, int workingHours) {
    this.name = name;
    this.workingHours = workingHours;
  }

  public String getName() {
    return name;
  }

  public int getWorkingHours() {
    return workingHours;
  }

  public void setWorkingHours(int workingHours) {
    this.workingHours = workingHours;
  }

}
