package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Sign in ']")
	WebElement signinBtn;
	
	@FindBy(xpath="//li[text()=' Hello, Admin ']")
	WebElement user;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void login(String uName, String pwd) {
		userName.sendKeys(uName);
		password.sendKeys(pwd);
		signinBtn.click();		
	}
	
	public String getUser() {
		return user.getText();
	}
	
	

}
