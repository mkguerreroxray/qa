package iMoneyTransObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//span[contains(text(),'REGISTER')])[1]")
	WebElement RegisterButton;

	@FindBy(id = "registerEmail")
	WebElement Email;

	@FindBy(id = "confirmEmail")
	WebElement ConfirmEmail;

	@FindBy(xpath = "//span[contains(.,'Create Account')]")
	WebElement CreateAccountButton;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement FirstName;

	@FindBy(xpath = "(//input[@type=\"text\"])[3]")
	WebElement LastName;

	@FindBy(xpath = "(//input[@type=\"text\"])[4]")
	WebElement DateofBirth;

	@FindBy(xpath = "//input[@id=\"prueba\"]")
	WebElement Phone;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath = "//div[@class=\"ng-select-container\"]")
	WebElement SelectCountry;
	
	@FindBy(xpath = "(//*[contains(text(),'Belgium')])[1]")
	WebElement Belgium;
	
	@FindBy(xpath = "//span[contains(.,' Join now ')]")
	WebElement JoinNow;
	
	@FindBy(xpath = "//h2[contains(.,' Verification of your e-mail address: ')]")
	WebElement HeaderValid;
	
	
	
	
	
	public WebElement HeaderValid() {

		return HeaderValid;

	}
	
	public WebElement JoinNow() {

		return JoinNow;

	}
	
	public WebElement Belgium() {

		return Belgium;

	}
	
	public WebElement SelectCountry() {

		return SelectCountry;

	}
	
	public WebElement Password() {

		return Password;

	}

	public WebElement Phone() {

		return Phone;

	}

	public WebElement DateofBirth() {

		return DateofBirth;

	}

	public WebElement LastName() {

		return LastName;

	}

	public WebElement FirstName() {

		return FirstName;

	}

	public WebElement RegisterButton() {

		return RegisterButton;

	}

	public WebElement Email() {

		return Email;

	}

	public WebElement ConfirmEmail() {

		return ConfirmEmail;
	}

	public WebElement CreateAccountButton() {

		return CreateAccountButton;
	}

}
