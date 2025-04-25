package taskManagementSystem;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {
	
	TaskManager taskManager = new TaskManager();
	@Test
	void Test() {
		//Remove from an empty list. As the collection is empty, it will not be able to remove and size will remain 0.
		removeTask("1",0);
		
		//A personal task will be added and size will become 1.
		addTask(new PersonalTask("1","personaltask 1","description1"),1);
		
		//This task won't be added as a task with same ID already exists. So size will remain as 1.
		addTask(new PersonalTask("1","personaltask 2","description2"),1);
		
		//It will remove the task, as it exists and size becomes 0 as no other task exists.
		removeTask("1",0);
		
		//A task with this ID does not exist, so it can't be removed. Size remains 0.
		removeTask("2",0);
		
		//It will add a work task. Size becomes 1 with the addition of a task.
		addTask(new WorkTask("2","worktask 2","description 2"),1);
		
		//It will not add a work task as a work task with same ID already exists. Size remains 1.
		addTask(new WorkTask("2","worktask 2","description 2"),1);
		
		//It will remove the task as it exists and size becomes 0.
		removeTask("2",0);
		
		//It will add a task and size becomes 1 as a task is successfully added and previously size was 0.
		addTask(new TeamWorkTask("3","teamwork task 1","description 1","teamname 1"),1);
		
		//It will not add a task as a task with same ID already exists. Size remains 1.
		addTask(new TeamWorkTask("3","teamwork task 2","description 2","teamname 2"),1);
		
		//It will successfully remove the task as a task with that ID exists and size becomes 0 as task is successfully removed.
		removeTask("3",0);	
	}
	
	//Testing reading and writing into a file.
	@Test
	void fileTesting() {
		
		String name="rayyan";
		
		//Testing for writing into the file.
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))){
			writer.write(name);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//Testing for reading into the file.
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("file.txt")))){
			String i = reader.readLine();
			Assertions.assertTrue(i.equals(name));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//This method is used for adding a task.
	private void addTask(Task t, int expectedSize) {
		taskManager.addTask(t);
		assertEquals(expectedSize, taskManager.getSize());
	}
	
	//This method is used for removing a task.
	private void removeTask(String ID, int expectedSize) {
		taskManager.removeTask(ID);
		assertEquals(expectedSize, taskManager.getSize());
	}
	
}
