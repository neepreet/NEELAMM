package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageElementss.CheckOutInfoPage;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy (id="checkout")
	WebElement CheckOutButton;

	public CheckOutInfoPage ClickOnCheckoutButton() {

		CheckOutButton.click();

		System.out.println("****Test case 10 >> CheckedOut any 1 product.");

		CheckOutInfoPage checkoutinfo = new CheckOutInfoPage(driver);
		return checkoutinfo;
	}
	
	
	
	
	
	

}
