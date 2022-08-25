package AgentsWebObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DestinationAmountsModulePage {

	WebDriver driver;

	public DestinationAmountsModulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "DestinationModule_radioToReceive")
	WebElement ToReceiveButton;

	public WebElement getToReceiveButton() {
		return ToReceiveButton;
	}

	@CacheLookup
	@FindBy(xpath = "//span[@aria-labelledby=\"select2-DestinationModule_DropDownListDestCity-container\"]")
	WebElement optionListButtonCity;

	@CacheLookup
	@FindBy(xpath = "//ul[@class=\"select2-results__options\"]/li")
	List<WebElement> optionListCity;

	@CacheLookup
	@FindBy(xpath = "//ul[@class=\"select2-results__options\"]/li")
	List<WebElement> optionListCountry;

	@CacheLookup
	@FindBy(xpath = "//span[@aria-labelledby=\"select2-DestinationModule_DropDownListDestCountry-container\"]")
	WebElement optionListButtonCountry;

	@CacheLookup
	@FindBy(xpath = "//input[@class=\"select2-search__field\"]")
	WebElement CountryCitySelection;

	@CacheLookup
	@FindBy(xpath = "//span[@id=\"select2-DestinationModule_DropdownListPaymentMode-container\"]")
	WebElement PaymentMode;

	@CacheLookup
	@FindBy(xpath = "//span[@aria-labelledby=\"select2-DestinationModule_DropDownListDestCity-container\"]")
	WebElement City;

	@CacheLookup
	@FindBy(xpath = "/html/body/span[3]/span/span[1]/input")
	WebElement CitySelection;

	@CacheLookup
	@FindBy(xpath = "//span[text() = 'MTB - MoneyTrans - Belgium']")
	WebElement PayersBelgium;

	@CacheLookup
	@FindBy(xpath = "//span[contains(.,'MTI - MoneyTrans Italia')]")
	WebElement PayersItaly;

	@CacheLookup
	@FindBy(xpath = "//div[@id=\"DestinationModule_divDownTransactionOfficeAndFees\"]/div[2]/div[1]/div[2]/div[3]/div[3]/select/option[2]")
	WebElement Destination;

	@CacheLookup
	@FindBy(xpath = "//input[@type=\"search\"]")
	WebElement DestinationSelection;

	@CacheLookup
	@FindBy(id = "DestinationModule_txtSend")
	WebElement ToSendAmount;

	@CacheLookup
	@FindBy(xpath = "/html/body/form/div[10]/div[4]/div[4]/div[2]/div[2]/div[1]/div/div[5]/div[1]/input")
	WebElement CalculateButton;

	@CacheLookup
	@FindBy(id = "DestinationModule_btnPaymentmethodPaper")
	WebElement CashButton;

	@CacheLookup
	@FindBy(xpath = "//a[text()=\"Transfers\"]")
	WebElement Transfers;

	@CacheLookup
	@FindBy(xpath = "//a[text()=\"Transfers List\"]")
	WebElement TransfersList;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"ctl00_PagesContainer_transfersListDataGrid\"]/tbody/tr[2]/td[6]")
	WebElement Control;

	@CacheLookup
	@FindBy(id = "ctl00_PagesContainer_btnSearch")
	WebElement SearchButton;

	@CacheLookup
	@FindBy(id = "ctl00_PagesContainer_btnViewDetails")
	WebElement ViewDetailsButton;

	@CacheLookup
	@FindBy(id = "btnAccessViewNotes")
	WebElement NotesButton;

	@CacheLookup
	@FindBy(id = "btnActionAddNote")
	WebElement AddNotesButton;

	@CacheLookup
	@FindBy(id = "txtNotesText")
	WebElement NotesText;

	@CacheLookup
	@FindBy(id = "btnNoteSaveChanges")
	WebElement SaveChangesButton;

	@CacheLookup
	@FindBy(id = "ctl00_PagesContainer_btnSearch")
	WebElement RefreshPageButton;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"transferNotesDataGrid\"]/tbody/tr[2]/td[3]")
	WebElement ValidateIfNoteVisible;

	@CacheLookup
	@FindBy(xpath = "(//div[@class=\"element\"])[1]")
	WebElement LogOut;

	@CacheLookup
	@FindBy(xpath = "(//div[@class=\"suboptions\"])[1]/ul/li")
	WebElement LogOutSubOption;

	@CacheLookup
	@FindBy(xpath = "//input[@id=\"btnSend\"]")
	WebElement SendButton;

	@CacheLookup
	@FindBy(css = "input#fraudControls_btnNext")
	WebElement ContinueButton;

	@CacheLookup
	@FindBy(css = "input#fraudControls_reasons_0")
	WebElement ReasonsRadioButton;

	@CacheLookup
	@FindBy(css = "input#fraudControls_btnContinue")
	WebElement SendInformationButton;

	public WebElement getPayersItaly() {
		return PayersItaly;
	}

	public WebElement getOptionListButtonCity() {
		return optionListButtonCity;
	}

	public List<WebElement> getOptionListCity() {
		return optionListCity;
	}

	public WebElement getContinueButton() {
		return ContinueButton;
	}

	public WebElement getReasonsRadioButton() {
		return ReasonsRadioButton;
	}

	public WebElement getSendInformationButton() {
		return SendInformationButton;
	}

	public WebElement getSendButton() {
		return SendButton;
	}

	public WebElement getOptionListButtonCountry() {
		return optionListButtonCountry;
	}

	public WebElement getLogOut() {
		return LogOut;
	}

	public WebElement getLogOutSubOption() {
		return LogOutSubOption;
	}

	public WebElement getRefreshPageButton() {
		return RefreshPageButton;
	}

	public WebElement getValidateIfNoteVisible() {
		return ValidateIfNoteVisible;
	}

	public WebElement getNotesButton() {
		return NotesButton;
	}

	public WebElement getAddNotesButton() {
		return AddNotesButton;
	}

	public WebElement getNotesText() {
		return NotesText;
	}

	public WebElement getSaveChangesButton() {
		return SaveChangesButton;
	}

	public WebElement getViewDetailsButton() {
		return ViewDetailsButton;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public WebElement getControl() {
		return Control;
	}

	public WebElement getTransfersList() {
		return TransfersList;
	}

	public WebElement getTransfers() {
		return Transfers;
	}

	public WebElement getCashButton() {
		return CashButton;
	}

	public WebElement getToSendAmount() {
		return ToSendAmount;
	}

	public WebElement getCalculateButton() {
		return CalculateButton;
	}

	public WebElement getDestination() {
		return Destination;
	}

	public WebElement getDestinationSelection() {
		return DestinationSelection;
	}

	public WebElement getPayersBelgium() {
		return PayersBelgium;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getCitySelection() {
		return CitySelection;
	}

	public WebElement getPaymentMode() {
		return PaymentMode;
	}

	public WebElement getCountryCitySelection() {
		return CountryCitySelection;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getoptionListCountry() {
		return optionListCountry;
	}

}
