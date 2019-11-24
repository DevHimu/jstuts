package com.tuts.waitTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class ExplicitWaitExample {
	WebDriver driver;
	@Test
	public void openBrowserTest()
	{
		driver = new Base().initChromeDriver("https://paytmmall.com/");
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement jioOffer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@alt=\"Jio Phone Offer | Best Price Online\"]")));
		jioOffer.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void trunkate()
	{
		driver.quit();
	}

}
