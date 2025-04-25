package taskManagementSystem;

public abstract class Task {

	//The Fields
	private String ID;
	private String name;
	private String description;
	
	//All The Constructors
	public Task() {
		
	}
	
	public Task(String ID) {
		this.ID=ID;
	}
	
	
	public Task(String ID, String name) {
		this.ID=ID;
		this.name=name;
	}
	
	public Task(String ID, String name, String description) {
		this.ID=ID;
		this.name=name;
		this.description=description;
	}
	
	//The getter and setter for field ID
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID=ID;
	}
	
	//The getter and setter for field name
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	//The getter and setter for field description
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description=description;
	}
	
	//Method for displaying each individual task 
	public void displayTask() {
		System.out.println("TASK ID: "+this.getID()+", Name: "+this.getName()+", description: " +this.getDescription()); 
	}
	
	
	
	
}
