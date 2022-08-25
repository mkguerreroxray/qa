package AgentsWebObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"txtUser\"]")
	WebElement Username;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	WebElement Password;

	@CacheLookup
	@FindBy(xpath = "//a[text()=\"Customers\"]")
	WebElement Customers;

	@CacheLookup
	@FindBy(xpath = "//a[text()=\"New Customer\"]")
	WebElement NewCustomer;

	@CacheLookup
	@FindBy(id = "ctl00_PagesContainer_HyperLink6")
	WebElement NewTransfer;

	public WebElement NewTransfer() {

		return NewTransfer;
	}

	public WebElement NewCustomer() {

		return NewCustomer;
	}

	public WebElement Customers() {

		return Customers;
	}

	public WebElement Password() {

		return Password;
	}

	public WebElement Username() {

		return Username;
	}

	public void LogInFunction() {

		Username.sendKeys("testEmployee");
		Password.sendKeys("Test123", Keys.ENTER);
//Test123
	}

	public void InvalidLogInFunction() {

		Username.sendKeys("testEmployee");
		Password.sendKeys("Test!", Keys.ENTER);

	}

	public void LogInFunctionOtherAgent() {

		Username.sendKeys(Keys.CLEAR, "fguler");
		Password.sendKeys(Keys.CLEAR, "Asd.12547970", Keys.ENTER);

	}

	public void LogInFunctionSpainPinCard() {

		Username.sendKeys("11568");
		Password.sendKeys("Test123", Keys.ENTER);

	}

	public void LogInFunctionBelgiumPinCard() {

		Username.sendKeys("MBRO_AGNES");
		Password.sendKeys("Test123!", Keys.ENTER);

	}

	public void LogInFunctionItalyPinCard() {

		Username.sendKeys("879A");
		Password.sendKeys("Test!2!", Keys.ENTER);

	}

}
