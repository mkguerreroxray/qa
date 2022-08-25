package iMoneyTransObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmileAccountPage {

	WebDriver driver;

	public SmileAccountPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@CacheLookup
	@FindBy(xpath = "//span[contains(.,'Smile account Mastercard®')]")
	WebElement SmileAccountMastercardButton;

	@CacheLookup
	@FindBy(xpath = "//span[contains(.,' Add Money ')]")
	WebElement AddMoneyButton;

	@CacheLookup
	@FindBy(xpath = "//input[@type=\"text\"]")
	WebElement AddMoneyBox;

	@CacheLookup
	@FindBy(xpath = "//span[contains(.,' Pay now ')]")
	WebElement PayNowButton;

	@CacheLookup
	@FindBy(xpath = "//a[contains(.,' History ')]")
	WebElement HistoryTab;

	@CacheLookup
	@FindBy(xpath = "(//input[@type=\"text\"])[3]")
	WebElement Search;

	@CacheLookup
	@FindBy(xpath = "(//span[contains(.,' Details ')])[1]")
	WebElement DetailsDeposit;

	@CacheLookup
	@FindBy(xpath = "//span[contains(.,' Repeat transaction ')]")
	WebElement RepeatTransaction;

	public WebElement RepeatTransaction() {

		return RepeatTransaction;
	}

	public WebElement DetailsDeposit() {

		return DetailsDeposit;
	}

	public WebElement Search() {

		return Search;
	}

	public WebElement HistoryTab() {

		return HistoryTab;
	}

	public WebElement PayNowButton() {

		return PayNowButton;

	}

	public WebElement AddMoneyBox() {

		return AddMoneyBox;

	}

	public WebElement AddMoneyButton() {

		return AddMoneyButton;

	}

	public WebElement SmileAccountMastercardButton() {

		return SmileAccountMastercardButton;

	}

}
