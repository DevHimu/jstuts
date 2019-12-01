package DataDrivenFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenFrameWorkTesting {
	ChromeDriver driver;

	@Test(dataProvider = "testdata")
	public void DemoProject(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://selenium/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://www.newtours.demoaut.com/");

		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Assert.assertTrue(driver.getTitle().matches("Find a Flight: Mercury Tours:"), "Invalid credentials");
		System.out.println("Login successful");
	}
	 @AfterMethod
	 void ProgramTermination()
	 {
	 driver.quit();
	 }

	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() {

		ReadExcelFile config = new ReadExcelFile("C:\\Users\\Himandri\\eclipse-workspace\\SeleniumTutorialBatch2\\src\\DataDrivenFrameWork\\DataDrivenTesting.xlsx");

		int rows = config.getRowCount(0);

		Object[][] credentials = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			credentials[i][0] = config.getData(0, i, 0);
			credentials[i][1] = config.getData(0, i, 1);
		}

		return credentials;
	}

}
