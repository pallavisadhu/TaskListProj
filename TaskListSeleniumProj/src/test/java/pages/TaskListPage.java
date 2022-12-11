package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskListPage {
	WebDriver driver;
	
	@FindBy(id="taskTitleInput")
	WebElement taskTitle;
	
	@FindBy(id="taskBodyInput")
	WebElement taskBody;
	
	@FindBy(id="datepickerduedate")
	WebElement dueDate;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement taskBtn;
	
	@FindBy(xpath="//div[@class='card-body']")
	WebElement cardBody;
	
	public TaskListPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void addTask(String title, String body, String date) throws InterruptedException {
		
		taskTitle.sendKeys(title);
		taskBody.sendKeys(body);
		dueDate.sendKeys(date);
		taskBtn.click();
		Thread.sleep(3000);

	}
	
	public String findTask() {
		return cardBody.getText();
		
	}

}
