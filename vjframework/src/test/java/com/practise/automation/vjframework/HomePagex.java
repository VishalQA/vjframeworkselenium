package com.practise.automation.vjframework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectx.LandingPagex;
import pageObjectx.LoginPagex;
import resourcesx.BaseClassx;

import java.io.File;
import java.io.IOException;
import java.util.List;



public class HomePagex extends BaseClassx{

	
		
		@Test(dataProvider="getData")
		public void basePageNavigation(String Username, String Password, String text ) throws IOException
		{
		
			 driver =initializeDriverx();
			 driver.get("http://qaclickacademy.com");
			 
			 // ================================================
			   	driver.getWindowHandles();
				int sizex = driver.findElements(By.tagName("iframe")).size();
				System.out.println(sizex);
				
				//****************************************A****************
//				String framename = driver.findElements(By.tagName("iframe")).
//				
//				System.out.println(sizex);
//				System.out.println(driver.switchTo().frame(0).getTitle());
				
				//*******************************************B*******************
				
				List<WebElement> ele = driver.findElements(By.tagName("iframe"));
			    System.out.println("Number of frames in a page :" + ele.size());
			    for(WebElement el : ele){
			        System.out.println("****** Id of a frame*******");
			        System.out.println("Frame Id of " +el+ "is ===>:" + el.getAttribute("id"));
			        System.out.println("****** Name of a frame*******");
			        System.out.println("Frame name of " +el+ "is ===>:" + el.getAttribute("name"));
			        System.out.println("****** Title of a frame*******");
			        System.out.println("Frame Title of " +el + "is ===>:" +el.getTagName());
			        System.out.println("****** Text of a frame*******");
			        System.out.println("Frame Text of " +el + "is ===>:" +el.getText());
			    }
				
//			  ***************************A***************
			  //wait for 10 seconds max for the frame
//			    WebDriverWait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
//			    wait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.FrameToBeAvailableAndSwitchToIt(By.Id("FRAMEID")));
				//***************************B***************
			    WebDriverWait wait = new WebDriverWait(driver,30);
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'NO THANKS')]")));
			    
			    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example copy somewhere
				FileUtils.copyFile(scrFile1, new File("C:\\Users\\jaju_v\\Downloads\\VJ_Automation\\Screens\\3_WithFramescreenShot.png"));
			    
			    
			    driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
				System.out.println("The frame is closed .");
//				***************************A***************
//			    driver.switchTo().parentFrame();
//			    driver.switchTo().defaultContent();
//				***************************B***************
				
				File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example copy somewhere
				FileUtils.copyFile(scrFile2, new File("C:\\Users\\jaju_v\\Downloads\\VJ_Automation\\Screens\\4_WithoutFramescreenShot.png"));
		//***************************A***************		
				//take screenshot of the entire page
//		        Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//		        try {
//		            ImageIO.write(screenshot.getImage(),"PNG",new File("path of the file"));
//		        } catch (IOException e) {
//		            // TODO Auto-generated catch block
//		            e.printStackTrace();
//		        }
		//***************************B***************		
			 
			 
			 
			 //==================================================
			 
			 
			 LandingPagex l = new LandingPagex(driver);
			l.getLoginx().click();
			 
			LoginPagex lp = new LoginPagex(driver);
			lp.getEmail().sendKeys(Username);
			lp.getPassword().sendKeys(Password);
//			System.out.println(text);
			lp.getLogin().click();
			
			
		}
		
		@DataProvider()
		public Object[][] getData() {
			Object[][] data = new Object[2][3];
			data[0][0] = "nonrestricteduser@qw.com";
			data[0][1] = "123456";
			data[0][2] = "Restricted User";
			
			data[1][0] = "restricteduser@qw.com";	
			data[1][1] = "45678";
			data[1][2] = "Non Restricted User";
			
			return data;
		}
		}