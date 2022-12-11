package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import readconfig.ConfigFileReader;

public class TestBase {
	
	public static WebDriver driver = null;
	ConfigFileReader cfr;
	
	@BeforeSuite
	public void initialize() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		cfr= new ConfigFileReader();
		driver.get(cfr.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@BeforeTest
	public void print() {
		System.out.println("Test Started");
	}
	
	
	@AfterTest
	public void printAfterTest() {
		System.out.println("Test Exited");
	}
	
	@AfterSuite
	public void quitBrowser() {
		driver.quit();
		
	}

}
