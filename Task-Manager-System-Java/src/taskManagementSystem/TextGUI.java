package taskManagementSystem;

import java.util.Scanner;

public class TextGUI {

	
	Scanner scan = new Scanner(System.in);
	TaskManager taskmanager = new TaskManager();
	FileIO fileIO = new FileIO();
	
	public void Tasks() {
		taskmanager.putAll(fileIO.readTasks());
		taskmanager.reminder();
	}
	
	public void menu(){
		
		while(true) {
						
			//The text-based user interface.
			System.out.println();
			System.out.println("WELCOME TO THE TASK MANAGER");
			System.out.println();
			System.out.println("Select your option:");
			System.out.println("1. Show all current tasks");
			System.out.println("2. Add a new personal task");
			System.out.println("3. Add a new work task");
			System.out.println("4. Add a new teamwork task");
			System.out.println("5. Remove an existing task");
			System.out.println("6. Exit the program");
			System.out.println();
			
			//Getting the option from the user.
			System.out.print("Enter your option: ");
			int choice = scan.nextInt();
			
			//If user selects the 1st option.
			if (choice==1) {
				taskmanager.allTask();
			}
			
			else if(choice==2) {
				
				//Getting the details from the user.
				System.out.println("Enter ID: ");
				String ID = scan.next();
				
				System.out.println("Enter name: ");
				String name = scan.next();
				
				//Checking whether they want a description or not
				System.out.println("Do you want to enter a description(y/n): ");
				String desc = scan.next();
				
				//It will add a task with the description.
				if (desc.equalsIgnoreCase("y")) {
					System.out.println("Enter description: ");
					String description = scan.next();
					
					Task t = new PersonalTask(ID,name,description);
					taskmanager.addTask(t);
				}
				//It will set the description as null and add the task.
				else {
					String description = null;
					Task t = new PersonalTask(ID,name,description);
					taskmanager.addTask(t);
				}
			}
			
			else if(choice==3) {
				//Getting the details from the user.
				System.out.println("Enter ID: ");
				String ID = scan.next();
				
				System.out.println("Enter name: ");
				String name = scan.next();
				
				System.out.println("Do you want to enter a description(y/n): ");
				String desc = scan.next();
				if (desc.equalsIgnoreCase("y")) {
					System.out.println("Enter description: ");
					String description = scan.next();
					
					Task t = new WorkTask(ID,name,description);
					taskmanager.addTask(t);
				}
				else {
					String description = null;
					Task t = new WorkTask(ID,name,description);
					taskmanager.addTask(t);
				}
			}
			
			else if(choice==4) {
				//Getting the details from the user.
				System.out.println("Enter ID: ");
				String ID = scan.next();
				
				System.out.println("Enter name: ");
				String name = scan.next();
				
				System.out.println("Do you want to enter a description(y/n): ");
				String desc = scan.next();
				
				if (desc.equalsIgnoreCase("y")) {
					System.out.println("Enter description: ");
					String description = scan.next();
					
					System.out.println("Enter Team Name: ");
					String teamName=scan.next();
					
					Task t = new TeamWorkTask(ID,name,description,teamName);
					taskmanager.addTask(t);
				}
				else {
					String description = null;
					
					System.out.println("Enter Team Name: ");
					String teamName=scan.next();
					
					Task t = new TeamWorkTask(ID,name,description,teamName);
					taskmanager.addTask(t);
				}
			}
			
			//If user selects the 6th option.
			else if (choice==5) {
				
				//Asking the ID of the task to be deleted.
				System.out.println("Enter ID: ");
				String ID = scan.next();
				taskmanager.removeTask(ID);
			}
			
			//If user selects the 7th option(exiting the program).
			else if(choice==6) {
				//Writes and stores the tasks in the file.
				fileIO.writeTasks(taskmanager);
				
				System.out.println("Thank you for using the task manager");
				break;
			}
			
			//If user enters an option that doesn't exist.
			else {
				System.out.println("Invalid Option. Try Again.");
				System.out.println();
			}
		}
	}	
}

