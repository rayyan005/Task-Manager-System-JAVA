package taskManagementSystem;

public class PersonalTask extends Task {

	//All the constructors
	public PersonalTask() {
		super();
	}
	
	public PersonalTask(String ID) {
		super(ID);
	}
	
	public PersonalTask(String ID, String name) {
		super(ID,name);
	}
	
	public PersonalTask(String ID, String name, String description) {
		super(ID, name, description);
	}
	
	//Method for displaying a personal task.
	@Override
	public void displayTask() {
		System.out.println("Personal Task - "+"ID: "+this.getID()+" Name: "+this.getName()+" Description: "+this.getDescription());
	}
	
	
}
