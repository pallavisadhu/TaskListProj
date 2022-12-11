package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
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
	
	@Test
	public void verifyAddTask() throws InterruptedException {
		tp.addTask("Project1", "Implement Page Object Model","12/12/2022");
		String r = tp.findTask();
		Assert.assertTrue(r.contains("Project1"));
		
	}

}
