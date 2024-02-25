package pageElementss;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
	
	
	WebDriver driver;

	public ProductDetailPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy(xpath="//*[contains(text(),'Backpack')]")
	WebElement BackPackProductName;

	@FindBy(className ="inventory_details_price")
	WebElement BackPackPrice;

	@FindBy(id ="back-to-products")
	WebElement BacktoProductsButton;

	public void VerifyProductDetails() throws InterruptedException {

//		Thread.sleep(3000);
		System.out.println("****Test case 5 >> Product details displayed successfully."); 

		String productname = BackPackProductName.getText();
		System.out.println("Product Name is :" + productname);

		String productprice = BackPackPrice.getText();
		System.out.println("Product Price is :" + productprice);


		BacktoProductsButton.click();
	}


}


}
