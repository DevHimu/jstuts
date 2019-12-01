package ExcelOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataWriteInToExcel {
	String url = "https://www.timeanddate.com/worldclock/";

	@Test
	public void writeIntoExcel() {
		// Geting file from System
		FileInputStream fi = null;
		try {
			fi = new FileInputStream("C:\\Users\\Himandri\\OneDrive\\Desktop\\Demo.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// creating workbook
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Selecting sheet
		XSSFSheet ws = null;
		Row r = null;

		ws = wb.getSheet("Sheet1");

		// Intializing chrome webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// getting URl
		driver.get(url);
		//geting table from UI
		WebElement timeWebTable = driver
				.findElement(By.xpath("/html/body/div[1]/div[6]/section[1]/div/section/div[1]/div/table/tbody"));
		// getting rows from webtable
		List<WebElement> rows = timeWebTable.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			// creating row in excel
			r = ws.createRow(i);

			// geting col from rows in webtable
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < cols.size(); j++) {
				Cell c = r.createCell(j);
				String cellvalue = cols.get(j).getText();
				c.setCellValue(cellvalue);
				System.out.println(cellvalue);
			}

		}

		FileOutputStream fo = null;
		try {
			fo = new FileOutputStream("C:\\Users\\Himandri\\OneDrive\\Desktop\\Demo.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
