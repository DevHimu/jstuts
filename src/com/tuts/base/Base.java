package com.tuts.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	WebDriver driver;
	
	public WebDriver initChromeDriver(String baseURL) {
		System.out.println("Launching google chrome browser..");
		driver = selectBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	private WebDriver selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEPATHDIR);
			driver = new ChromeDriver();
		}
		
		return driver;
	}

	// The URL will be used to open in the browser of driver(WebDriver)
	public void getURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	// Wait for the visibility of the element for a certain amount of time
	public void waitforElement(long timeoutseconds, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, timeoutseconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
