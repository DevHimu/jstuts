package com.tuts.webTableTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class TestingOFSameXpath {
	WebDriver driver;
	
	// //*[contains(text(),"Scorecard" )and @id='button-text']
	@Test
	public void webTableTesting()
	{
		driver = new Base().initChromeDriver("https://m.cricbuzz.com/cricket-commentary");
		String scorecard = "//*[contains(text(),\"Scorecard\" )and @id='button-text']";
		List<WebElement> teams = driver.findElements(By.xpath(scorecard));
		System.out.println(teams.size());
	    for (WebElement ele :teams)
	    {
	    	System.out.println(ele.getText());
	    }
	    teams.get(4).click();
	    
	    //System.out.println(driver.getCurrentUrl());
	    
	    String xpath ="//*[@id=\"top\"]/div/div[12]/div[2]/div[1]/table/tbody/tr/td";
	    List<WebElement>BatsMen = driver.findElements(By.xpath("//*[@id=\"top\"]/div/div[12]/div[2]/div[1]/table/tbody/tr/td"));
	    String xpathOfBatsMan = "//*[@id=\"top\"]/div/div[12]/div[2]/div[1]/table/tbody/tr/td";
	    String batsmanxpath1= "//*[@id='top']/div/div[12]/div[2]/div[";
	    String batsmanxpath2= "]/table/tbody/tr[1]/td[1]/a/b/span[@class='bat-bowl-data']";
	    for(int i= 2 ; i<= BatsMen.size();i++)
	    {	    	
	    	WebElement batsmanEle = driver.findElement(By.xpath(batsmanxpath1+i+batsmanxpath2));//.getAttribute("value");
	    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", batsmanEle);
	    	System.out.println("Batsman Name is : "+batsmanEle.getAttribute("textContent"));
	    	// System.out.println("Batsman Name is : "+batsmanEle.getAttribute("innerValue"));
	    }
		 
	}
	
	@AfterTest
	public void browserTrunket()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

}
