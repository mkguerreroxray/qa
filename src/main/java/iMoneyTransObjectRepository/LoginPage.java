package iMoneyTransObjectRepository;

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
	@FindBy(xpath = "(//span[contains(text(),'LOGIN')])[1]")
	WebElement Login;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement Username;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement Password;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"loginButton\"]")
	WebElement LoginSubmit;

	@CacheLookup
	@FindBy(xpath = "//div[text()=\" Please select the service you need. \"]")
	WebElement LoginValidation;

	public WebElement LoginValidation() {

		return LoginValidation;

	}

	public WebElement Login() {

		return Login;

	}

	public WebElement Username() {

		return Username;
	}

	public WebElement Password() {

		return Password;
	}

	public WebElement LoginSubmit() {

		return LoginSubmit;

	}

	public void LogInFunction() {

		Login.click();
		Username.clear();
		Password.clear();
		Username.sendKeys("pluyo@moneytrans.eu");
		Password.sendKeys("Test1983!");
		LoginSubmit().click();

	}

	public void InvalidLogInFunction() {

		Login.click();
		Username.clear();
		Password.clear();
		Username.sendKeys("fguler@moneytrans");
		Password.sendKeys("Test1982!");
		LoginSubmit().click();

	}

}
