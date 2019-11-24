package com.tuts.webTableTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.tuts.base.Base;

public class WebTableTesting {

	WebDriver driver;
	
	@Test
	public void webTableTesting()
	{
		driver = new Base().initChromeDriver("http://placement.freshersworld.com/states-and-capitals-of-india/331219166989");

		String stateXpath1 = "//*[@id='content-des']/table[1]/tbody/tr[ ";
		String stateXpath2 = "]/td[2] ";
		
		String capitalXpath1 ="//*[@id='content-des']/table[1]/tbody/tr[";
		String capitalXpath2 = "]/td[3] ";
		
		String table = "//*[@id='content-des']/table[1]/tbody";
		WebElement webtable = driver.findElement(By.xpath(table));
		List<WebElement> rowsOfTable = webtable.findElements(By.tagName("tr"));
		System.out.println(rowsOfTable.size());
		
		  for(int i=2 ; i<= rowsOfTable.size() ; i++) { String stateXpath = stateXpath1+i+stateXpath2;
		  WebElement statename = driver.findElement(By.xpath(stateXpath));
		  System.out.print(statename.getText()); String capitalXpath = capitalXpath1+
		  i+ capitalXpath2; WebElement capitalname =
		  driver.findElement(By.xpath(capitalXpath)); System.out.print(
		  "        "+capitalname.getText());
		  
		  System.out.println(); }
		 
	}
	
	@AfterTest
	public void browserTrunket()
	{
		driver.close();
	}
}
