package KeyWordDrivenFrameWorkTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Actions {
	
	/*
	 * ActionKeywords open_browser navigate input_UserName input_Password
	 * click_login verify_login closeBrowser
	 */


	public static WebDriver driver;
	
	/*
	 * public Actions(WebDriver driver) { // TODO Auto-generated constructor stub
	 * Actions.driver = driver; }
	 */

	public static void open_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void navigate() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\selenium\\chromedriver.exe"); driver = new ChromeDriver();
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
	}

	public static void input_UserName() {
		driver.findElement(By.name("userName")).sendKeys("mercury");
	}

	public static void input_Password() {
		driver.findElement(By.name("password")).sendKeys("mercury");
	}

	public static void click_login() {
		driver.findElement(By.name("login")).click();
	}

	@Test
	public static void verify_login() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours:");
	}

	public static void closeBrowser() {
		driver.quit();
	}

}
