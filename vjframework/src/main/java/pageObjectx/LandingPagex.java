package pageObjectx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPagex  {
	
	public WebDriver driver;
	
	By login = By.xpath("//span[contains(text(),'Login')]");
	
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	

	public LandingPagex(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}




	public WebElement getLoginx()  {
		
//		driver =initializeDriverx();
//		driver.get("http://qaclickacademy.com");
 
	
			return driver.findElement(login);
			
		}
	
	public WebElement getTitle() {
		
		return driver.findElement(title);
	}
		
	
	}
	



