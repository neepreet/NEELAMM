package pageElementss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage {
	
	
	WebDriver driver;

	public CheckOutCompletePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy(id="back-to-products")
	WebElement BackHomeButton;

	public void ClickBackHomeButton() {

		BackHomeButton.click();

		System.out.println("***Test Case 13 >> Returned to products page.");
	}


}
