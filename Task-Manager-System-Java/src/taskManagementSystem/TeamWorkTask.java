package taskManagementSystem;

public class TeamWorkTask extends WorkTask implements Remindable{

	//The additional field for the team name.
	private String teamName;
	
	//All the constructors
	public TeamWorkTask() {
		super();
	}
	
	public TeamWorkTask(String ID) {
		super(ID);
	}
		
	public TeamWorkTask(String name, String teamName) {
		super(name);
		this.setTeamName(teamName);
	}

	public TeamWorkTask(String ID, String name, String teamName) {
		super(ID,name);
		this.setTeamName(teamName);
	}
	
	public TeamWorkTask(String ID, String name, String description, String teamName) {
		super(ID, name, description);
		this.setTeamName(teamName);
	}
	
	//Method for displaying a TeamWork task.
	@Override
	public void displayTask() {
		System.out.println("Team Work Task -"+" ID: "+this.getID()+" Name: "+this.getName()+" Description: "+this.getDescription()+" Team Name: "+this.getTeamName());
	}
	
	//Getter for TeamName
	public String getTeamName() {
		return teamName;
	}
	
	//Setter for TeamName
	public void setTeamName(String teamName) {
		this.teamName=teamName;
	}
	
	//Method that will remind if a TeamWork task is there.
	public void remindUser() {
		System.out.println("TeamWork Task - "+"Task Name: "+this.getName()+", Description: "+this.getDescription()+", Team Name: "+this.getTeamName());
	}
	
}
