package com.tuts.MouseActionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class AmazonSelectMirrorLessCamera {
	WebDriver driver;
	@Test
	public void selectMirrorLessCamera()
	{
		driver = new Base().initChromeDriver("https://www.flipkart.com/");
		try {
			driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		WebElement electronics = driver.findElement(By.xpath("//*[text()='Electronics']"));
		Actions action = new Actions(driver);
		action.moveToElement(electronics).perform();
		action.moveToElement(driver.findElement(By.xpath("//*[text()='Mi']"))).click().perform();
	}

}
