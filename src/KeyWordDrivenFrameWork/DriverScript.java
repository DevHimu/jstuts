package KeyWordDrivenFrameWork;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;

import org.testng.Assert;

import KeyWordDrivenFrameWorkTest.ReadExcelData;



public class DriverScript {
	public static void main(String[] args) throws Exception {
		// Declaring the path of the Excel file with the name of the Excel file
		String sPath = "C:\\Users\\Himandri\\OneDrive\\Desktop\\keywordDrivenFrameWorkTestCase.xlsx";
		// FileInputStream fis = new FileInputStream(sPath);
		ReadExcelData.setExcelFile(sPath, "RegistrationTC");
		for(int i=1;i<ReadExcelData.getRowCount(0);i++)
		{
			String sActions = ReadExcelData.getCellData(i, 1);
			if(sActions.equals("openBrowser"))
			{
				CustomActions.openBrowser();
			}
			else if(sActions.equals("navigate"))
			{
				CustomActions.navigate();
			}
			else if (sActions.equals("clickRegistrationLink\r\n" + 
					""))
			{
				CustomActions.clickRegistrationLink();
			}
			else if (sActions.equals("enterFirstName")) {
				CustomActions.enterFirstName("Manoj");
				
			}
			else if(sActions.equals("enterlastName"))
			{
				CustomActions.enterlastName("Priya Panda");
			}
			else if(sActions.equals("enterPhoneNumber"))
			{
				CustomActions.enterPhoneNumber("99999999999999");
			}
			else if (sActions.contentEquals("enterEmailID")) {
				CustomActions.enterEmailID("HelloEmail@email.com");
				
			}
			else if(sActions.contentEquals("enterAddress"))
			{
				CustomActions.enterAddress("Harmauv");
			}
			else if(sActions.contentEquals("enterCity"))
			{
				CustomActions.enterCity("Bengaluru");
			}
			else if(sActions.contentEquals("enterState"))
			{
				CustomActions.enterCity("KA");
			}
			else if(sActions.contentEquals("enterPostalCode"))
			{
				CustomActions.enterCity("560045");
			}
			else if(sActions.contentEquals("selectCountry"))
			{
				CustomActions.selectCountry("INDIA");
			}
			else if(sActions.contentEquals("enterUserName"))
			{
				CustomActions.enterUserName("ManojPriya");
			}
			else if(sActions.contentEquals("enterPassword"))
			{
				CustomActions.enterPassword("HelloPassword#");
			}
			else if(sActions.contentEquals("enterConfirmPassword"))
			{
				CustomActions.enterPassword("HelloPassword#");
			}
			else if(sActions.contentEquals("clickOnSubmitButton"))
			{
				CustomActions.clickOnSubmitButton();
			}
			else if(sActions.contentEquals("verifyConfirmationMessage"))
			{
				boolean msg = CustomActions.verifyConfirmationMessage();
				Assert.assertTrue(msg,"Expected true but false");
			}

			
		}
		
		
	}
}

