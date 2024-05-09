
package org.base;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
    public static WebDriver driver;
    
	public void getDriver(String browserType) {

		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.err.println("Invalid Browser Type");
			break;
		}
	}

	public void getUrl(String url) {
		driver.get("https://www.amazon.in/");
	}

	public void winMax() {
		driver.manage().window().maximize();
	}

	public void textSendByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}
	public void textSendByJS(WebElement element, String keysToSend) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", element);
	}

	public void screenCapture(String name) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\user\\Pictures\\SELELNIUM SC.S\\" + name + ".jpeg");
		FileUtils.copyFile(source, target);
	}

	public void sleep(long millis) throws InterruptedException {
		Thread.sleep(millis);

	}

	public void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	@SuppressWarnings("resource")
	public String readExcell(int rowNum, int cellNum) throws IOException {

		// To locate the Excel
		File file = new File("C:\\Users\\user\\Pictures\\Saved Pictures\\Book1.xlsx");

		// To get File as a Input
		FileInputStream stream = new FileInputStream(file); // throws FileNotFoundException

		Workbook book = new XSSFWorkbook(stream);// throws IOException

		// to get sheet from workbook
		Sheet sheet = book.getSheet("Sheet1");

		// To get Row from Sheet
		Row row = sheet.getRow(rowNum);

		// to get Cell from Row
		Cell cell = row.getCell(cellNum);

		// To find Cell is STRING || NUMERIC
		CellType cellType = cell.getCellType();
		String value = null;

		switch (cellType) {
		case STRING:
			value = cell.getStringCellValue();
			break;

		case NUMERIC:

			// To Find Cell is Date format or Not
			if (DateUtil.isCellDateFormatted(cell)) {
				// To get Date format cell
				Date dateCellValue = cell.getDateCellValue();
				// To Define Date Format
				SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
				value = simple.format(dateCellValue);

			} else {

				// To get Numeric Cell value from Numeric Cell
				double numericCellValue = cell.getNumericCellValue();
				// double to BigDecimal
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				// BigDecimal to String
				value = valueOf.toString();

			}

			break;

		default:
			System.err.println("InValid_Cell_Type");
			break;
		}

		return value;
	}
	
	public void WindowHandling() {
	String parID = driver.getWindowHandle();
	Set<String>allwindIDs = driver.getWindowHandles();
	for (String s: allwindIDs) {
		if (! parID.equals(s)) {
			driver.switchTo().window(s);
		}
	}}}










