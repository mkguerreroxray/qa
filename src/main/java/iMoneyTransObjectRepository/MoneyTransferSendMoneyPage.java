package iMoneyTransObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyTransferSendMoneyPage {

	WebDriver driver;

	public MoneyTransferSendMoneyPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[text()=\" SEND MONEY \"]")
	WebElement SendMoneyButton;

	@FindBy(xpath = "//span[text()=\"Money Transfer\"]")
	WebElement MoneyTransferButton;

	@FindBy(xpath = "//input[@type='text']")
	WebElement SelectDestinationCountry;

	@FindBy(xpath = "//ng-select[@ng-reflect-name=\"DestinationCountry\"]")
	WebElement SelectDestinationCountryBox;

	@FindBy(xpath = "//span[contains(.,'Belgium')]")
	WebElement SelectDestinationCountryResult;

	@FindBy(xpath = "//span[text()=\"Bank Deposit\"]")
	WebElement BankDeposit;

	@FindBy(xpath = "//span[text()=\"Cash Pickup\"]")
	WebElement CashPickup;

	@FindBy(xpath = "//span[text()=\" EUR\"]")
	WebElement EUR;

	@FindBy(xpath = "//span[text()=\" Next step \"]")
	WebElement NextStep;

	@FindBy(xpath = "(//*[@class=\"name-column ng-star-inserted\"])[1]")
	WebElement SelectRecipient;

	@FindBy(xpath = "//span[text()=\" Charity/Aid Payment \"]")
	WebElement CharityAidPayment;

	@FindBy(xpath = "//span[text()=\" Cash Tips \"]")
	WebElement CashTips;

	@FindBy(xpath = "//div[text()=\"MasterCard\"]")
	WebElement SelectPaymentMethod;

	@FindBy(xpath = "(//input[@type=\"text\"])[1]")
	WebElement YouSend;

	@FindBy(xpath = "(//span[contains(.,'Send')])[2]")
	WebElement Send;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement SelectSendingReason;

	@FindBy(xpath = "//span[contains(.,'Education')]")
	WebElement SelectSendingReasonResult;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement SelectSourceofFunds;

	@FindBy(xpath = "//span[contains(text(),'Salary')]")
	WebElement SelectSourceofFundsResult;

	@FindBy(xpath = "(//input[@type=\"text\"])[2]")
	WebElement SelectCity;

	@FindBy(xpath = "//span[contains(.,'Gent')]")
	WebElement SelectCityResult;

	public WebElement SelectCityResult() {

		return SelectCityResult;
	}

	public WebElement SelectCity() {

		return SelectCity;
	}

	public WebElement SelectSourceofFundsResult() {

		return SelectSourceofFundsResult;
	}

	public WebElement SelectSendingReasonResult() {

		return SelectSendingReasonResult;
	}

	public WebElement EUR() {

		return EUR;
	}

	public WebElement NextStep() {

		return NextStep;
	}

	public WebElement CashPickup() {

		return CashPickup;
	}

	public WebElement BankDeposit() {

		return BankDeposit;
	}

	public WebElement SelectDestinationCountryResult() {

		return SelectDestinationCountryResult;
	}

	public WebElement SelectDestinationCountryBox() {

		return SelectDestinationCountryBox;
	}

	public WebElement SelectDestinationCountry() {

		return SelectDestinationCountry;
	}

	public WebElement MoneyTransferButton() {

		return MoneyTransferButton;
	}

	public WebElement SendMoneyButton() {

		return SendMoneyButton;
	}

	public WebElement Send() {

		return Send;
	}

	public WebElement YouSend() {

		return YouSend;
	}

	public WebElement SelectPaymentMethod() {

		return SelectPaymentMethod;
	}

	public WebElement CashTips() {

		return CashTips;
	}

	public WebElement SelectSourceofFunds() {

		return SelectSourceofFunds;
	}

	public WebElement CharityAidPayment() {

		return CharityAidPayment;
	}

	public WebElement SelectSendingReason() {

		return SelectSendingReason;
	}

	public WebElement SelectRecipient() {

		return SelectRecipient;
	}

}
