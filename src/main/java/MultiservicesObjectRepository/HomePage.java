package MultiservicesObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//h2[text()='Dashboard']")
	WebElement LoginVerify;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder='User name (login)']")
	WebElement UserName;

	@CacheLookup
	@FindBy(xpath = "//input[@type=\"password\"]")
	WebElement Password;

	@CacheLookup
	@FindBy(css = "button.btn__size.primary")
	WebElement Enter;

	@CacheLookup
	@FindBy(xpath = "//div[text()=\" Easy Bill \"]")
	WebElement EasyBill;

	@CacheLookup
	@FindBy(xpath = "//input[@placeholder=\"Enter Customer Name\"]")
	WebElement EnterCustomerName;

	@CacheLookup
	@FindBy(xpath = "(//button[contains(text(),' Select ')])[1]")
	WebElement SelectCustomer;

	@CacheLookup
	@FindBy(css = ".btn.btn-primary.pointer-cursor")
	WebElement SelectCustomerLast;

	@CacheLookup
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement ContinueButton;

	@CacheLookup
	@FindBy(xpath = "//span[text()=' Search Company / IBAN ']")
	WebElement SearchCompanyIban;

	@CacheLookup
	@FindBy(xpath = "(//input[@type=\"text\"])[1]")
	WebElement ModalBox;

	@CacheLookup
	@FindBy(xpath = "//button[text()=' OK ']")
	WebElement OKButton;

	@CacheLookup
	@FindBy(xpath = "//div[@class=\"col-md-6 ng-star-inserted\"]/div/input")
	WebElement FreeCommunicationRadioButton;

	@CacheLookup
	@FindBy(id = "freeCommunication")
	WebElement FreeCommunicationTextBox;

	@CacheLookup
	@FindBy(xpath = "(//button[@class=\"btn scan-button btn-primary\"])[3]")
	WebElement InvoiceScan;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Other Documents']")
	WebElement OtherDocuments;

	@CacheLookup
	@FindBy(xpath = "//a[text()='Add file from your computer']")
	WebElement FrontID;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/app-root/ng-component/div/div/mt-eab-sale/div[3]/div/div/div[2]/form/div[5]/div/div/div[3]/div[1]/lib-mt-amount-input/div/div/div/input")
	WebElement Calculator;

	@CacheLookup
	@FindBy(xpath = "//span[text()=' Calculate ']")
	WebElement Calculate;

	@CacheLookup
	@FindBy(xpath = "(//span[text()=' Continue '])[2]")
	WebElement ContinueLast;

	@CacheLookup
	@FindBy(xpath = "//span[text()=' Pay Bill ']")
	WebElement PayBill;

	@CacheLookup
	@FindBy(css = ".done-success.form-subtitle")
	WebElement OperationDoneValidation;

	public WebElement getSelectCustomerLast() {
		return SelectCustomerLast;
	}

	public WebElement getLoginVerify() {
		return LoginVerify;
	}

	public WebElement getOperationDoneValidation() {
		return OperationDoneValidation;
	}

	public WebElement getPayBill() {
		return PayBill;
	}

	public WebElement getContinueLast() {
		return ContinueLast;
	}

	public WebElement getCalculate() {
		return Calculate;
	}

	public WebElement getCalculator() {
		return Calculator;
	}

	public WebElement getFrontID() {
		return FrontID;
	}

	public WebElement getOtherDocuments() {
		return OtherDocuments;
	}

	public WebElement getInvoiceScan() {
		return InvoiceScan;
	}

	public WebElement getFreeCommunicationRadioButton() {
		return FreeCommunicationRadioButton;
	}

	public WebElement getFreeCommunicationTextBox() {
		return FreeCommunicationTextBox;
	}

	public WebElement getOKButton() {
		return OKButton;
	}

	public WebElement getSearchCompanyIban() {
		return SearchCompanyIban;
	}

	public WebElement getModalBox() {
		return ModalBox;
	}

	public WebElement getContinueButton() {
		return ContinueButton;
	}

	public WebElement getSelectCustomer() {
		return SelectCustomer;
	}

	public WebElement getEasyBill() {
		return EasyBill;
	}

	public WebElement getEnterCustomerName() {
		return EnterCustomerName;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getEnter() {
		return Enter;
	}

}
