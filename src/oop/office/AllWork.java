package oop.office;

public class AllWork {

	private Task[] tasks;

	private int freePlacesForTask;

	private int currentUnassignedTask;

	public AllWork() {
		tasks = new Task[100];
		freePlacesForTask = tasks.length;
		currentUnassignedTask = -1;
	}

	public void addTask(Task task) {
		if (freePlacesForTask == tasks.length) {
			currentUnassignedTask++;
		}
		
		if (freePlacesForTask > 0) {
			freePlacesForTask--;
			tasks[tasks.length - 1 - freePlacesForTask] = task;
			System.out.println("Task \"" + task.getName() + "\" has been added to the tasks");
		} else {
			System.out.println("Tasks pool is full! Task " + task.getName()
					+ " can not be added !");
		}
	}
	
	public Task getNextTask () {
		Task nextTask = null;
		if (currentUnassignedTask >= 0 && currentUnassignedTask < tasks.length) {
			nextTask =  tasks[currentUnassignedTask++];
		}
		
		return nextTask;
			
	}
	
	public boolean isAllWorkDone () {
		boolean isAllWorkDone = true;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null && tasks[i].getWorkingHours() > 0) {
				isAllWorkDone = false;
				break;
			}
		}
		return isAllWorkDone;
	}

}
