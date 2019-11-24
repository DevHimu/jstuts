package com.tuts.MouseActionTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class FlipKartMiMouseActionTest {
	WebDriver driver;

	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		driver = new Base().initChromeDriver("https://www.studytonight.com/");
		/*
		 * driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click(); try
		 * { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		WebElement tutorial = driver.findElement(By.xpath("//*[@id=\"hero-dropdown\"]"));
		 WebElement html = driver.findElement(By.xpath("//*[@id=\"hero-dropdown\"]/div/div/div[2]/div/div/div[1]/a[1]/p")) ;
		Actions action = new Actions(driver);
		action.moveToElement(tutorial).build().perform();
		action.moveToElement(html).click().perform();
		//html.click();
		Thread.sleep(10000);
	
		
	}
	
	@AfterTest
	public void trunkate() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}


}
