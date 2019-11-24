package com.tuts.waitTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class ImplicitWaitExample {
	WebDriver driver;

	@Test
	public void implicitWaitTestForFlipKart()
	{
		driver = new Base().initChromeDriver("https:www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try
		{
			driver.findElement(By.xpath("//*[text() ='Login & Signup']")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	@AfterTest
	public void trunkate()
	{
		driver.quit();
	}

}
