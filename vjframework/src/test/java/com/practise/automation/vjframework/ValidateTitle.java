package com.practise.automation.vjframework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjectx.LandingPagex;
import resourcesx.BaseClassx;

public class ValidateTitle extends BaseClassx {
	


	
	@SuppressWarnings("deprecation")
	@Test
	public void getTitleValidation() throws IOException {
		
		driver = initializeDriverx();
		driver.get("http://www.qaclickacademy.com/");
		LandingPagex t = new LandingPagex(driver);
		Assert.assertEquals(t.getTitle().getText(), "FEATURED COURSES");
		
		
		
		
		
		
		
	}
	

}
