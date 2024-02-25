package pageElements;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.AbstractMethods;



public class HomePage extends AbstractMethods {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);				
	}

	@FindBy (xpath="//a[@id='item_4_title_link']/child::div")
	WebElement BackPack;

	@FindBy (id="add-to-cart-sauce-labs-backpack")
	WebElement AddBackPackButton;
	By backpackcartbutton = By.id("add-to-cart-sauce-labs-backpack");

	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement CartCount;

	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement AddBoltTShirtButton;

	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	WebElement AddFleeceJacketButton;

	@FindBy (id="shopping_cart_container")
	WebElement CartButton;

	@FindBy (id="react-burger-menu-btn")
	WebElement MenuButton;

	@FindBy(id="logout_sidebar_link")
	WebElement LogOutButton;
	By logoutbutton = By.id("logout_sidebar_link");

	public void VerifyHomePage() {

		String homepageurl = driver.getCurrentUrl();
		Assert.assertEquals(homepageurl, "https://www.saucedemo.com/inventory.html");

		System.out.println("***Test case 3 >> User landed on HomePage.");
	}

	public ProductDetailPage GoToProductDetailPage() {

		BackPack.click();

		System.out.println("***Test case 4 >> User visited Product.");

		ProductDetailPage productdetailpage = new ProductDetailPage(driver);
		return productdetailpage;
	}

	public void AddProductToCart() {

		Wait_Till_Link_Is_Clickable(backpackcartbutton);
		AddBackPackButton.click();

		System.out.println("****Test case 6 >> 1 Product added to Cart.");

		String productcount = CartCount.getText();

		System.out.println("****Test case 7 >> Checked current count of the Cart.");
		System.out.println("****Current count of products in Cart is :"+ productcount);


	}

	public void AddMoreProductsAndCheckCount() {

		AddBoltTShirtButton.click();
		AddFleeceJacketButton.click();

		System.out.println("****Test case 8 >> More Products added to Cart.");

		String productcount1 = CartCount.getText();

		System.out.println("****Test case 9 >> Checked updated count of Cart.");
		System.out.println("After adding more products Cart count is :"+ productcount1);

	}

	public CartPage GoToCart() {

		CartButton.click();

		CartPage cp = new CartPage(driver);
		return cp;
	}

	public void SortProduct() {

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sel = new Select(dropdown);
		sel.selectByVisibleText("Price (high to low)");

		System.out.println("****Test case 14 >> Products sorting from DropDown.");
	}

	public void Logout() {

		MenuButton.click();

		Wait_Till_Link_Is_Clickable(logoutbutton);
		LogOutButton.click();

		System.out.println("****Test case 15 >>User logged out successfully.");

	}
}


