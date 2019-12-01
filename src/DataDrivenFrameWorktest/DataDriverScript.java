package DataDrivenFrameWorktest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriverScript {
	WebDriver driver;

	@Test(dataProvider = "userData")
	public void testLogin(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/index.php");
		// Store properties of user field in element
		String name_UserName = "userName";

		// Store properties of password field in element
		String name_password = "password";

		// Store properties of submit button in element
		String name_Submit = "submit";

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		// driver.findElement(By.name(name_UserName));
		DataDriverScript.findElementByName(driver, name_UserName).sendKeys(username);
		DataDriverScript.findElementByName(driver, name_password).sendKeys(password);
		DataDriverScript.findElementByName(driver, name_Submit).click();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().matches("Login: Mercury Tours"), "Invalid credentials");

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	public static WebElement findElementByName(WebDriver driver, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
	}

	@DataProvider(name = "userData")
	public Object[][] testDataFeeder() {

		FileInputStream fi = null;
		try {
			fi = new FileInputStream(
					"C:\\Users\\Himandri\\eclipse-workspace\\SeleniumTutorialBatch2\\src\\DataDrivenFrameWork\\DataDrivenTesting.xlsx");
		} catch (FileNotFoundException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet workSheet = wb.getSheet("Data");
		int rowCount = workSheet.getLastRowNum() + 1;
		Object[][] credential = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			credential[i][0] = workSheet.getRow(i).getCell(0).getStringCellValue();
			credential[i][1] = workSheet.getRow(i).getCell(1).getStringCellValue();
		}

		/*
		 * Object[][] credential = new Object[3][2]; credential[0][0] ="user";
		 * credential[0][1] ="user"; credential[1][0] ="user"; credential[1][1]
		 * ="password"; credential[2][0] ="mercury"; credential[2][1] ="mercury";
		 */

		return credential;
	}
	
	public int getRowCount(XSSFSheet ws)
	{
		return ws.getLastRowNum()+1;
	}
}
