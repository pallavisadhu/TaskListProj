package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
	
	@FindBy(xpath="//h5[@class='card-title']")
	List <WebElement> cardTitleList;
	
	@FindBy(xpath="//div[@class='card w-100']")
	List <WebElement> taskCount;
	
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
	
	public void deleteTask(String title) throws InterruptedException {
		try {
		for(WebElement c:cardTitleList) {
			if(c.getText().equals(title)) {
				c.findElement(By.xpath("//button[text()=' Delete ']")).click();
				Thread.sleep(3000);
				
			}
		}
		}catch(StaleElementReferenceException e) {
			for(WebElement c:cardTitleList) {
				if(c.getText().equals(title)) {
					c.findElement(By.xpath("//button[text()=' Delete ']")).click();
					Thread.sleep(3000);
					
				}
			}
		}
	
	}
	
	public int countTask() {
		return taskCount.size();
		
	}

}
