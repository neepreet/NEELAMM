package pageElementss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageElements.CheckOutCompletePage;


public class CheckOutOverviewPage {
	
	WebDriver driver;

	public CheckOutOverviewPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy(id="finish")
	WebElement FinishButton;

	public CheckOutCompletePage ClickOnFinishButton() {

		FinishButton.click();

		System.out.println("****Test case 12 >> Completed checkout process.");

		CheckOutCompletePage checkoutcomplete = new CheckOutCompletePage(driver);
		return checkoutcomplete;


	}

}
