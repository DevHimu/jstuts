package KeyWordDrivenFrameWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomActions {
	public static WebDriver driver;
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();		
	}
	public static void navigate()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
	}
	public static void clickRegistrationLink()
	{
		driver.findElement(By.xpath("//*[text()=\"REGISTER\"]"));
		
	}
	public static void enterFirstName(String firstName)
	{
		driver.findElement(By.name("firstName")).sendKeys(firstName);;
	}
	public static void enterlastName(String lastName)
	{
		driver.findElement(By.name("lastName")).sendKeys(lastName);
	}
	public static void enterPhoneNumber(String phoneNumber)
	{
		driver.findElement(By.name("phone")).sendKeys(phoneNumber);
	}
	public static void enterEmailID(String emailID)
	{
		driver.findElement(By.name("userName")).sendKeys(emailID);
	}
	public static  void enterAddress(String address)
	{
		driver.findElement(By.name("address1")).sendKeys(address);
	}
	public static void enterCity(String city)
	{
		driver.findElement(By.name("city")).sendKeys(city);
	}
	public static void enterState(String state)
	{
		driver.findElement(By.name("state")).sendKeys(state);
	}
	public static void enterPostalCode(String postalcode)
	{
		driver.findElement(By.name("postalCode")).sendKeys(postalcode);
	}
	public static void selectCountry(String country)
	{
		//String name = "Hello" ;
		Select dropdownForCountry = new Select(driver.findElement(By.name("country")));
		dropdownForCountry.selectByVisibleText(country);
				
	}
	public static void enterUserName(String username)
	{
		driver.findElement(By.id("email")).sendKeys(username);
	}
	public static void enterPassword(String password)
	{
		driver.findElement(By.name("password")).sendKeys(password);
	}
	public  static void enterConfirmPassword(String password)
	{
		driver.findElement(By.name("confirmPassword")).sendKeys(password);
	}
	public static void  clickOnSubmitButton()
	{
		driver.findElement(By.name("register")).sendKeys(Keys.ENTER);
	}
	
	public static boolean verifyConfirmationMessage()
	{
		String ConfirmationMessage = "\r\n" + 
				"\r\n" + 
				" Thank you for registering. \r\n" + 
				"        You may now ";
		
		String xpathConfirmation = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/text()";
		String confirmationMsg =driver.findElement(By.xpath(xpathConfirmation)).getText();
		return confirmationMsg.contentEquals(ConfirmationMessage);
	}


}
