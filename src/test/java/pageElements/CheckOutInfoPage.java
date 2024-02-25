package pageElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class CheckOutInfoPage {
	
	WebDriver driver;

	public CheckOutInfoPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy(id="first-name")
	WebElement FirstName;

	@FindBy(id="last-name")
	WebElement LastName;

	@FindBy(id="postal-code")
	WebElement PostCodeBox;

	@FindBy(id="continue")
	WebElement ContinueButton;

	public CheckOutOverviewPage FillInfo() throws IOException {

		ExcelUtility xs = new ExcelUtility();
		FileInputStream fs = new FileInputStream("C:\\Users\\attar\\eclipse-workspace\\SwagLab_Project\\src\\testData\\SwagLabData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		FirstName.sendKeys((sheet.getRow(3).getCell(1).toString()));
		LastName.sendKeys((sheet.getRow(4).getCell(1).toString()));
		PostCodeBox.sendKeys((sheet.getRow(5).getCell(1).toString()));

		ContinueButton.click();

		System.out.println("****Test case 11 >> Filled checkout information.");

		CheckOutOverviewPage checkoutoverview = new CheckOutOverviewPage(driver);
		return checkoutoverview;

	}

}
