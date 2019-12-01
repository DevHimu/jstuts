package KeyWordDrivenFrameWorkTest;

public class DriverScript {
	public static void main(String[] args) throws Exception {
		// Declaring the path of the Excel file with the name of the Excel file
		String sPath = "C:\\Users\\Himandri\\eclipse-workspace\\SeleniumTutorialBatch2\\src\\KeyWordDrivenFrameWorkTest\\keyWordDrivenFrameworkTest.xlsx";

		// Here we are passing the Excel path and SheetName as arguments to connect with
		// Excel file
		ReadExcelData.setExcelFile(sPath, "Sheet1");

		// Hard coded values are used for Excel row & columns for now
		// Hard coded values are used for Excel row & columns for now
		// In later chapters we will replace these hard coded values with varibales
		// //This is the loop for reading the values of the column 3 (Action Keyword)
		// row by row
		for (int iRow = 1; iRow <= 7; iRow++) {
			String sActions = ReadExcelData.getCellData(iRow, 1);

			// Comparing the value of Excel cell with all the keywords in the "Actions"
			// class
			
			/*
			 * ActionKeywords open_browser navigate input_UserName input_Password
			 * click_login verify_login closeBrowser
			 */
			if (sActions.equals("open_browser")) {
				// This will execute if the excel cell value is 'openBrowser'
				// Action Keyword is called here to perform action
				Actions.open_browser();
			} else if (sActions.equals("navigate")) {
				Actions.navigate();
			} else if (sActions.equals("input_UserName")) {
				Actions.input_UserName();
			} else if (sActions.equals("input_Password")) {
				Actions.input_Password();
			} else if (sActions.equals("click_login")) {
				Actions.click_login();;
			} else if (sActions.equals("verify_login")) {
				Actions.verify_login();
			} else if (sActions.equals("closeBrowser")) {
				Actions.closeBrowser();
			}
		}
	}
}
