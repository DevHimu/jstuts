package com.tuts.MouseActionTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class MouseActionTest {
	WebDriver driver;

	@Test
	public void openBrowserTest() throws InterruptedException
	{
		driver = new Base().initChromeDriver("https://www.hdfcbank.com/personal/tools-and-calculators/personal-loan-calculator");
		//amountSlider : //*[@id="js-rangeslider-0"]
		WebElement amountSlider = driver.findElement(By.xpath("//*[@id=\"js-rangeslider-0\"]"));
		/*
		 * Dimension sliderSize = amountSlider.getSize(); int sliderWidth =
		 * sliderSize.getWidth(); System.out.println(" sliderwidth "+
		 * sliderSize.getWidth());
		 * System.out.println("slider width before scrolls "+sliderWidth); int xCoord =
		 * amountSlider.getLocation().getX(); System.out.println("x cordinate "+
		 * xCoord);
		 * System.out.println("y coordinate "+amountSlider.getLocation().getY());
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(amountSlider).click().dragAndDropBy(amountSlider,(
		 * xCoord+sliderWidth)/2, 0).build().perform();
		 * System.out.println("slider x point after scroll "+amountSlider.getLocation().
		 * getX());
		 * System.out.println("slider width after scroll "+amountSlider.getSize());
		 * System.out.println("slider y point after scroll "+amountSlider.getLocation().
		 * getY()); Thread.sleep(10000);
		 */
		
		//====================Move By offset==============================
//		Actions action= new Actions(driver);
//		Dimension sliderSize = amountSlider.getSize();
//		int width = sliderSize.getWidth();
//		int offsetX =( (width*50)/100);
//	    //action.moveToElement(amountSlider, offsetX ,1);
////	    action.clickAndHold();
////        action.release();
////        action.perform();
//		
//		====================xy coordinate =========
		
		 //Used points class to get x and y coordinates of element.
		 Point point = amountSlider.getLocation();
		 Actions action= new Actions(driver);
		 Dimension sliderSize = amountSlider.getSize();
		 int width = sliderSize.getWidth();
		/*
		 * int xcord = point.getX();
		 * System.out.println("Position of the webelement from left side is "+xcord
		 * +" pixels"); int ycord = point.getY();
		 * System.out.println("Position of the webelement from top side is "+ycord
		 * +" pixels"); // action.moveToElement(amountSlider, xcord+width/2
		 * ,0).release().build().perform();
		 * 
		 * WebElement pointer =
		 * driver.findElement(By.xpath("//*[@id=\"js-rangeslider-0\"]/div[2]")); Point
		 * pointOfPointer = pointer.getLocation(); int pointerxcord =
		 * pointOfPointer.getX(); int pointerycord = pointOfPointer.getY();
		 */
		 System.out.println(width);
		 System.out.println(width-200);
		 action.clickAndHold(amountSlider).moveByOffset((width-210), 0).release().perform();
		 
		 
		 
	}

	@AfterTest
	public void trunkate() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
