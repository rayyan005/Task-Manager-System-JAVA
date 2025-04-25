package taskManagementSystem;

public class Run {
	
	static TextGUI textMenu = new TextGUI();
	
	public static void main(String[] args) {
		
		//Displays the reminder.
		textMenu.Tasks();
		
		//The text-based interface.
		textMenu.menu();
		
	}
}