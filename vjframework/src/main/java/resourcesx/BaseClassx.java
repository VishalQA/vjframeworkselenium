package resourcesx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BaseClassx {
	

		  public  WebDriver driver ;
		public Properties propx;
		
	public WebDriver initializeDriverx() throws IOException
	{
		
	 propx= new Properties();
	FileInputStream fisx=new FileInputStream("C:\\Users\\jaju_v\\eclipse-workspace\\vjframework\\src\\main\\java\\resourcesx\\datax.properties");

	propx.load(fisx);
	String browserName=propx.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
			//execute in chrome driver
		
	}
	else if (browserName.equals("firefox"))
	{
		 driver= new FirefoxDriver();
		//firefox code
	}
	else if (browserName.equals("IE"))
	{
		 driver= new InternetExplorerDriver();
//		IE code
	}

	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	return driver ;

	}


	}
