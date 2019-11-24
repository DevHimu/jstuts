package com.tuts.MouseActionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class ContextClickExample {
	WebDriver driver;
	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		driver = new Base().initChromeDriver("https://www.google.co.in/");
		WebElement gmailEvent = driver.findElement(By.linkText("Gmail"));
		Actions action = new Actions(driver);
		action.contextClick(gmailEvent).sendKeys("W").click().build().perform();
		//action.contextClick(gmailEvent).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).click().build().perform();
		Thread.sleep(3000);
		
		
	}
	
	@AfterTest
	public void trunkate() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
