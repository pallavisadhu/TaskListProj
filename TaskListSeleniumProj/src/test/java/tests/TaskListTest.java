package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.TaskListPage;
import readconfig.ConfigFileReader;

public class TaskListTest extends TestBase{
	
	ConfigFileReader cfr;
	TaskListPage tp;
	
	@BeforeClass
	public void init() throws FileNotFoundException, IOException {
		cfr = new ConfigFileReader();
		tp=PageFactory.initElements(driver, TaskListPage.class);		

	}
	
	@Test(priority=1)
	public void verifyAddTask() throws InterruptedException {
		System.out.println("Verify add task");
		tp.addTask("Project1", "Implement Page Object Model","12/12/2022");
		String r = tp.findTask();
		System.out.println(r);
		Assert.assertTrue(r.contains("Project1"));
		
	}
	
	@Test(priority=2)
	public void verifyDeleteTask() throws InterruptedException {
		System.out.println("Verify delete task");
		tp.deleteTask("Project1");
	}
	

}
