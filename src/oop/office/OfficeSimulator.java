package oop.office;

public class OfficeSimulator {

	public static void main(String[] args) {
		AllWork allWork = new AllWork();

		allWork.addTask(new Task("Fix NPE Exception", 2));
		allWork.addTask(new Task("Do more testing", 14));
		allWork.addTask(new Task("Implement search", 21));
		allWork.addTask(new Task("Fix class cast", 1));
		allWork.addTask(new Task("Encode string in UTF-8", 8));
		allWork.addTask(new Task("Sum up all values", 3));
		allWork.addTask(new Task("Reimplement sort ligoc", 5));
		allWork.addTask(new Task("Optimize DB query", 7));
		allWork.addTask(new Task("Implement user login", 9));
		allWork.addTask(new Task("Add better encription", 17));
		allWork.addTask(new Task("Add more bundle keys", 10));
		allWork.addTask(new Task("Update Java version", 1));

		Employee ivan = new Employee("Ivan", allWork);
		Employee georgi = new Employee("Georgi", allWork);
		Employee pavel = new Employee("Pavel", allWork);

		int i = 1;
		while (!allWork.isAllWorkDone()) {
			System.out.println();
			System.out.println("########       WORKING DAY " + i++ + "     ################");
			System.out.println();
			ivan.startWorkingDay();
			georgi.startWorkingDay();
			pavel.startWorkingDay();
			
			simulateWork(allWork, ivan);
			simulateWork(allWork, georgi);
			simulateWork(allWork, pavel);

		}
	}
	
	private static void simulateWork (AllWork allWork, Employee employee) {
		Task taskForToday = employee.getCurrentTask();
		if(taskForToday == null || taskForToday.getWorkingHours() == 0) {
			taskForToday = allWork.getNextTask();
			employee.setCurrentTask(taskForToday);
		} 
			
		employee.work();
		
	}
		
}

