package pageElementss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import pageElements.HomePage;
import utilities.AbstractMethods;
import utilities.ExcelUtility;


public class LandingPage AbstractMethods{

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void GoTo() {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		System.out.println("****Test case1 >> Application Launched successfully...");
	}

	@FindBy(id="user-name")
	WebElement UserName;

	@FindBy(id="password")
	WebElement Password;

	@FindBy(id="login-button")
	WebElement LoginButton;

	@FindBy(xpath="//h3[@data-test='error']")
	WebElement Errormessage;

	public HomePage Login() throws IOException {
		try {
		ExcelUtility xs = new ExcelUtility();
		FileInputStream fs = new FileInputStream("C:\\Users\\attar\\eclipse-workspace\\SwagLab_Project\\src\\testData\\SwagLabData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		UserName.sendKeys((sheet.getRow(0).getCell(1).toString()));
		Password.sendKeys((sheet.getRow(2).getCell(1).toString()));

		LoginButton.click();

		System.out.println("****Test case 2 >> User Loggedin Successfully...");

		HomePage hp = new HomePage(driver);

		return hp;
		}
		catch(Exception e) {
			System.out.println("Data retrival failing from Excelsheet");
		}
		return null;

	}

	public void LoginWithIncorrectCredentials() throws IOException {

		ExcelUtility xs = new ExcelUtility();
		FileInputStream fs = new FileInputStream("C:\\Users\\attar\\eclipse-workspace\\SwagLab_Project\\src\\testData\\SwagLabData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		UserName.sendKeys((sheet.getRow(1).getCell(1).toString()));
		Password.sendKeys((sheet.getRow(2).getCell(1).toString()));

		LoginButton.click();

		System.out.println("****Test case 16 >> Login with incorrect Credentials.");

		String errormsg = Errormessage.getText();
		Assert.assertEquals(errormsg, "Epic sadface: Sorry, this user has been locked out.");
		System.out.println("****Test Case 17 >> Print the Error message :" + errormsg );

	}


}



