package taskManagementSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


public class FileIO {

	private final String file = ("C:/Users/RAYYAN/eclipse/java-2023-09/file.txt");
	TaskManager taskManager = new TaskManager();
	
	//Tasks are written into the file using this.
	public void writeTasks(HashMap<String,Task> tasks) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
			for (Task task: tasks.values()) {
				//This writes the tasks.
				writer.write(writeTask(task));
				writer.newLine();
		}
	} catch (IOException e) {
		e.printStackTrace();
		}
	}
	
	private String writeTask(Task task) {
		String taskString = "";
		String teamName = "";
		if(task instanceof PersonalTask) {
			taskString = "1";
		}
		else if (task instanceof TeamWorkTask) {
			taskString = "2";
			teamName = ((TeamWorkTask)task).getTeamName();
		}
		else if(task instanceof WorkTask) {
			taskString="3";
			
		}
		taskString = taskString+","+task.getID()+","+task.getName()+","+task.getDescription()+","+teamName;
		return taskString;
	}
	
	//The tasks are read here.
	public HashMap<String, Task> readTasks(){
		HashMap<String,Task> tasks = new TaskManager();
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(file)))){
			String line = reader.readLine();
			while(line != null) {
				String[] task = line.split(",");
				String type = task[0];
				String ID = task[1];
				String name = task[2];
				String description = task[3];
				
				if (type.equals("1")) {
					tasks.put(ID, new PersonalTask(ID,name,description));
				}
				else if (type.equals("2")) {
					String teamName = task[4];
					tasks.put(ID, new TeamWorkTask(ID,name,description,teamName));
					
				}
				else if(type.equals("3")) {
					tasks.put(ID, new WorkTask(ID,name,description));
				}
				
				line=reader.readLine();		
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tasks;	
	}
}
	
	

	
	
	
	

