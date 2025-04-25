package taskManagementSystem;

public class WorkTask extends Task implements Remindable{

	//All the constructors
	public WorkTask() {
		super();
	}
	
	public WorkTask(String ID) {
		super(ID);
	}

	public WorkTask(String ID, String name) {
		super(ID,name);
	}
	
	public WorkTask(String ID, String name, String description) {
		super(ID, name, description);
	}
	
	//Method for displaying a work task.
	@Override
	public void displayTask() {
		System.out.println("Work Task -"+" ID: "+this.getID()+" Name: "+this.getName()+" Description: "+this.getDescription());
	}
	
	//Method for reminding the user if a work task is there.
	public void remindUser() {
		System.out.println("Work Task -"+" Task Name: "+this.getName()+", Description: "+this.getDescription());
	}
	
}
