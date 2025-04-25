package taskManagementSystem;
import java.util.HashMap;


public class TaskManager extends HashMap<String,Task>{

	
	//The method to add a task. Shows if a task already exists and will ignore the new task.
	public boolean addTask(Task t) {
		
		//Checking if a specific task is already existing.
		if (containsKey(t.getID())) {
			System.out.println("This task already exists. Please use a different ID.");
			return false;
		}
		
		else {
			put(t.getID(), t);
			return true;	
		}
	}
	
	//The method to remove a task
	public boolean removeTask(String ID) {
		
		if (containsKey(ID)) {
			remove(ID);
			return true;
		}
		else {
			return false;
		}
	}
	
	//The getSize method which returns the no. of tasks currently present.
	public int getSize() {
		return size();
	}
	
	//Method that is going to display all the tasks.
	public void allTask() {
	    if (size() == 0) {
	        System.out.println("No tasks available.");
	        return;
	    }
	    
	    System.out.println("\nAll Tasks:");
	    System.out.println("----------");
	    forEach((ID,task) -> {
	        task.displayTask();
	    });
	    System.out.println("----------");
	}
	
	//Method for displaying the reminder
	public void reminder() {
		System.out.println("REMINDER!!!");
		forEach((ID,task) -> {
			if (task instanceof Remindable) {
				Remindable Task = (Remindable) task;
				Task.remindUser();
			}
		});
	}
}
	

