package iMoneyTransObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileTopUpPage {

	WebDriver driver;

	public MobileTopUpPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[contains(., \"Mobile Top-Up\")]")
	WebElement MobileTopUpButton;

	@FindBy(xpath = "//span[contains(., \" SEND TOP-UP \")]")
	WebElement SendTopUpButton;

	@FindBy(xpath = "(//td[@class=\"name-column ng-star-inserted\"])[1]")
	WebElement SelectRecipient;

	@FindBy(xpath = "(//span[contains(.,'total: 1 EUR')])[2]")
	WebElement Amount;

	@FindBy(xpath = "(//div[@class=\"method-picker__control__option\"])[2]")
	WebElement SelectPaymentMethod;

	@FindBy(xpath = "//input[@id=\"cvvfield\"]")
	WebElement SecurityCode;

	@FindBy(xpath = "//input[@id=\"form_submit\"]")
	WebElement ConfirmButton;

	@FindBy(xpath = "//input[@id=\"submit_button\"]")
	WebElement SubmitButton;

	@FindBy(xpath = "//*[@id=\"paymentaccepted\"]")
	WebElement PaymentConfirmation;

	@FindBy(xpath = "//a[contains(.,' Recipients ')]")
	WebElement Recipients;

	@FindBy(xpath = "//span[contains(.,' ADD RECIPIENT ')]")
	WebElement AddRecipient;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement FirstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement LastName;

	@FindBy(xpath = "//input[@id=\"prueba\"]")
	WebElement Phone;

	@FindBy(xpath = "//span[contains(.,' SAVE RECIPIENT ')]")
	WebElement SaveRecipient;

	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement Search;

	@FindBy(xpath = "//span[contains(.,'EDIT')]")
	WebElement Edit;

	@FindBy(xpath = "//span[contains(.,'Delete')]")
	WebElement Delete;

	@FindBy(xpath = "//div[@class=\"modal-body pr-0 pl-0\"]/div/div[4]/div/lib-mt-button-big/button")
	WebElement DeleteConfirm;

	@FindBy(xpath = "//*[contains(.,' The Recipient TEST AUTOMATION is succesfully deleted. ')]")
	WebElement DeleteConfirmMessage;

	@FindBy(xpath = "//span[contains(.,'TEST AUTOMATION')]")
	WebElement RecipientNameConfirmation;

	@FindBy(xpath = "(//td[@class=\"ng-star-inserted\"])[1]")
	WebElement PhoneCheck;

	@FindBy(xpath = "//span[contains(.,' SAVE CHANGES ')]")
	WebElement SaveChanges;

	@FindBy(xpath = "//a[contains(., ' FAQ ')]")
	WebElement FAQTab;

	public WebElement FAQTab() {

		return FAQTab;

	}

	public WebElement SaveChanges() {

		return SaveChanges;

	}

	public WebElement PhoneCheck() {

		return PhoneCheck;

	}

	public WebElement RecipientNameConfirmation() {

		return RecipientNameConfirmation;

	}

	public WebElement DeleteConfirmMessage() {

		return DeleteConfirmMessage;

	}

	public WebElement DeleteConfirm() {

		return DeleteConfirm;

	}

	public WebElement Delete() {

		return Delete;

	}

	public WebElement Edit() {

		return Edit;

	}

	public WebElement Search() {

		return Search;

	}

	public WebElement SaveRecipient() {

		return SaveRecipient;

	}

	public WebElement Phone() {

		return Phone;

	}

	public WebElement LastName() {

		return LastName;

	}

	public WebElement FirstName() {

		return FirstName;

	}

	public WebElement AddRecipient() {

		return AddRecipient;

	}

	public WebElement Recipients() {

		return Recipients;

	}

	public WebElement PaymentConfirmation() {

		return PaymentConfirmation;
	}

	public WebElement SubmitButton() {

		return SubmitButton;
	}

	public WebElement ConfirmButton() {

		return ConfirmButton;
	}

	public WebElement SecurityCode() {

		return SecurityCode;
	}

	public WebElement SelectPaymentMethod() {

		return SelectPaymentMethod;
	}

	public WebElement Amount() {

		return Amount;
	}

	public WebElement SelectRecipient() {

		return SelectRecipient;
	}

	public WebElement SendTopUpButton() {

		return SendTopUpButton;
	}

	public WebElement MobileTopUpButton() {

		return MobileTopUpButton;
	}

}
