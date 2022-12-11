package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pages.LoginPage;
import readconfig.ConfigFileReader;

public class LoginTest extends TestBase{
	
	LoginPage lp;
	ConfigFileReader cfr;
	
	@BeforeClass
	public void init() throws FileNotFoundException, IOException {
		cfr=new ConfigFileReader();
		lp=PageFactory.initElements(driver, LoginPage.class);		

	}
	
	@Test(priority=1)
	public void verifyTitle() {
		System.out.println("Verify Title");
		Assert.assertEquals(lp.getTitle(), "Task List");
	}
	
	@Test(priority=2)
	public void verifyLogin() {
		System.out.println("Verify Login");
		lp.login(cfr.getUserName(), cfr.getPassword());
		Assert.assertEquals(lp.getUser(), "Hello, Admin");
	}

}
