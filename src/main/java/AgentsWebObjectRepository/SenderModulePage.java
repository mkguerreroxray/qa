package AgentsWebObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SenderModulePage {

	WebDriver driver;

	public SenderModulePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"searchCustomersTable\"]/tbody/tr/td[4]")
	List<WebElement> ExistentSenders;

	public List<WebElement> getExistentSenders() {
		return ExistentSenders;
	}

	@CacheLookup
	@FindBy(xpath = "(//td[@class])[2]")
	WebElement CustomerCode;

	@CacheLookup
	@FindBy(id = "SenderModule_txtFirstName")
	WebElement FirstName;

	@CacheLookup
	@FindBy(id = "SenderModule_txtLastName")
	WebElement LastName;

	@CacheLookup
	@FindBy(id = "SenderModule_txtNumDoc")
	WebElement IDNumber;

	@CacheLookup
	@FindBy(xpath = "//input[@id=\"SenderModule_btnScan\"]")
	WebElement ScanButton;

	@CacheLookup
	@FindBy(xpath = "//a[text()=\"Identification Document Images\"]")
	WebElement ID_Document_Images;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"front-wrapper\"]/form/div/button[2]")
	WebElement fileInputFront;

	@CacheLookup
	@FindBy(xpath = "(//button[@class=\"btn btn-default ng-binding\"])[2]")
	WebElement fileInputBack;

	@CacheLookup
	@FindBy(xpath = "//select[@name=\"SenderModule$comboTypeDoc\"]")
	WebElement IDType;

	@CacheLookup
	@FindBy(xpath = "//input[@name=\"SenderModule$txtValidityDate\"]")
	WebElement ExpiryDate;

	@CacheLookup
	@FindBy(css = ".ui-datepicker-year")
	WebElement UIDatePickerYear;

	@CacheLookup
	@FindBy(css = ".ui-datepicker-days-cell-over.ui-datepicker-today")
	WebElement ExpiryDateDay;

	@CacheLookup
	@FindBy(xpath = "//input[@name=\"SenderModule$txtDeliveryDate\"]")
	WebElement DeliveryDate;

	@CacheLookup
	@FindBy(css = ".ui-datepicker-days-cell-over.ui-datepicker-today")
	WebElement DeliveryDateDay;

	@CacheLookup
	@FindBy(id = "SenderModule_AutoCompleteDeliveryCity_DropdownListCountry")
	WebElement DeliveryCountry;

	@CacheLookup
	@FindBy(xpath = "//div[@id=\"SenderModule_AutoCompleteDeliveryCity_autocomplete_city_selector_container\"]/div[2]/div[1]/input")
	WebElement DeliveryCity;

	@CacheLookup
	@FindBy(id = "SenderModule_partnerOccupationCombo")
	WebElement Occupation;

	@CacheLookup
	@FindBy(id = "SenderModule_dropDownListTransferSourceOfFunds")
	WebElement SourceOfFunds;

	@CacheLookup
	@FindBy(id = "SenderModule_dropDownListTransferReason")
	WebElement PurposeOfTransaction;

	@CacheLookup
	@FindBy(id = "SenderModule_comboNationality")
	WebElement BirthCountry;

	@CacheLookup
	@FindBy(id = "SenderModule_txtBirthDate")
	WebElement BirthDate;

	@CacheLookup
	@FindBy(xpath = "//select[@class=\"ui-datepicker-year\"]")
	WebElement BirthDateUIDatePickerYear;

	@CacheLookup
	@FindBy(xpath = "//a[text()=\"1\"]")
	WebElement BirthDatePickerDay;

	@CacheLookup
	@FindBy(id = "SenderModule_radioSex_0")
	WebElement Gender;

	@CacheLookup
	@FindBy(id = "SenderModule_txtMail")
	WebElement Mail;

	@CacheLookup
	@FindBy(id = "SenderModule_txtThelephone")
	WebElement Phone;

	@CacheLookup
	@FindBy(id = "SenderModule_AutoCompleteCitySelector_txtCitySelector")
	WebElement ResidenceCity;

	@CacheLookup
	@FindBy(id = "SenderModule_txtStreet")
	WebElement Street;

	@CacheLookup
	@FindBy(id = "SenderModule_txtHouseNumber")
	WebElement HouseNumber;

	@CacheLookup
	@FindBy(id = "SenderModule_txtHouseLetter")
	WebElement TextHouseLetter;

	@CacheLookup
	@FindBy(id = "SenderModule_txtPostalCode")
	WebElement ZipCode;

	@CacheLookup
	@FindBy(id = "btnNext")
	WebElement NextButton;

	@CacheLookup
	@FindBy(xpath = "//div[@class=\"messageContainerAriadNext containerSizesAriadNext\"]/div[4]/div[4]/input[1]")
	WebElement EditIDData;

	@CacheLookup
	@FindBy(xpath = "//div[@class=\"messageContainerAriadNext containerSizesAriadNext\"]/div[4]/div[4]/input[1]")
	WebElement EditIDData2;

	@CacheLookup
	@FindBy(css = "input#AriadNextTxbFirstName")
	WebElement EditIDDataFirstName;

	@CacheLookup
	@FindBy(id = "AriadNextTxbLastName")
	WebElement EditIDDataLastName;

	@CacheLookup
	@FindBy(id = "AriadNextTxbIdDocDeliveryCountry")
	WebElement EditIDDataDeliveryCountry;

	@CacheLookup
	@FindBy(id = "AriadNextTxbIdDocNumber")
	WebElement EditIDDataDocNumber;

	@CacheLookup
	@FindBy(id = "AriadNextContinueButton")
	WebElement EditIDDataContinueButton;

	@CacheLookup
	@FindBy(name = "SenderModule$comboDocAuthority")
	WebElement DocAuthority;

	@CacheLookup
	@FindBy(name = "SenderModule$rangesOfAnnualIncomeCombo")
	WebElement AnnualIncome;

	@CacheLookup
	@FindBy(id = "SenderModule_chkNoFiscalCode")
	WebElement FiscalCode;

	@CacheLookup
	@FindBy(name = "SenderModule$dropDownListSuspicious")
	WebElement SuspiciousBehaviour;

	@CacheLookup
	@FindBy(id = "senderSearchName")
	WebElement ExistentCustomerSelectionByName;

	@CacheLookup
	@FindBy(id = "senderSearchPhone")
	WebElement ExistentCustomerSelectionByPhone;

	@CacheLookup
	@FindBy(id = "senderSearchCode")
	WebElement ExistentCustomerSelectionByCustomerCode;

	@CacheLookup
	@FindBy(id = "SenderModule_txtSeararch")
	WebElement ExistentCustomerTxtSearch;

	@CacheLookup
	@FindBy(id = "sender_btnSearch")
	WebElement ExistentCustomerSearchButton;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"searchCustomersTable\"]/tbody/tr[2]/td[4]")
	WebElement TestUserSelection;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"searchCustomersTable\"]/tbody/tr[2]/td[4]")
	WebElement TestUserSelectionItaly;

	@CacheLookup
	@FindBy(xpath = "//*[@onclick=\"$('#searchCustomersTable').table_search_customer('loadcustomer')\"]")
	WebElement AcceptButton;

	@CacheLookup
	@FindBy(id = "btnEditCustomer")
	WebElement EditButton;

	public WebElement getCustomerCode() {
		return CustomerCode;
	}

	public WebElement getTestUserSelectionItaly() {
		return TestUserSelectionItaly;
	}

	public WebElement getEditButton() {
		return EditButton;
	}

	public WebElement getAcceptButton() {
		return AcceptButton;
	}

	public WebElement getTestUserSelection() {
		return TestUserSelection;
	}

	public WebElement getExistentCustomerSelectionByName() {
		return ExistentCustomerSelectionByName;
	}

	public WebElement getExistentCustomerSelectionByCustomerCode() {
		return ExistentCustomerSelectionByCustomerCode;
	}

	public WebElement getExistentCustomerSelectionByPhone() {
		return ExistentCustomerSelectionByPhone;
	}

	public WebElement getExistentCustomerTxtSearch() {
		return ExistentCustomerTxtSearch;
	}

	public WebElement getExistentCustomerSearchButton() {
		return ExistentCustomerSearchButton;
	}

	public WebElement getSuspiciousBehaviour() {
		return SuspiciousBehaviour;
	}

	public WebElement getAnnualIncome() {
		return AnnualIncome;
	}

	public WebElement getFiscalCode() {
		return FiscalCode;
	}

	public WebElement getDocAuthority() {
		return DocAuthority;
	}

	public WebElement getEditIDDataDeliveryCountry() {
		return EditIDDataDeliveryCountry;
	}

	public WebElement getEditIDDataDocNumber() {
		return EditIDDataDocNumber;
	}

	public WebElement getEditIDDataContinueButton() {
		return EditIDDataContinueButton;
	}

	public WebElement getEditIDData() {
		return EditIDData;
	}

	public WebElement getEditIDData2() {
		return EditIDData2;
	}

	public WebElement getEditIDDataFirstName() {
		return EditIDDataFirstName;
	}

	public WebElement getEditIDDataLastName() {
		return EditIDDataLastName;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getIDNumber() {
		return IDNumber;
	}

	public WebElement getScanButton() {
		return ScanButton;
	}

	public WebElement getID_Document_Images() {
		return ID_Document_Images;
	}

	public WebElement getFileInputFront() {
		return fileInputFront;
	}

	public WebElement getFileInputBack() {
		return fileInputBack;
	}

	public WebElement getIDType() {
		return IDType;
	}

	public WebElement getExpiryDate() {
		return ExpiryDate;
	}

	public WebElement getUIDatePickerYear() {
		return UIDatePickerYear;
	}

	public WebElement getExpiryDateDay() {
		return ExpiryDateDay;
	}

	public WebElement getDeliveryDate() {
		return DeliveryDate;
	}

	public WebElement getDeliveryDateDay() {
		return DeliveryDateDay;
	}

	public WebElement getDeliveryCountry() {
		return DeliveryCountry;
	}

	public WebElement getDeliveryCity() {
		return DeliveryCity;
	}

	public WebElement getOccupation() {
		return Occupation;
	}

	public WebElement getSourceOfFunds() {
		return SourceOfFunds;
	}

	public WebElement getPurposeOfTransaction() {
		return PurposeOfTransaction;
	}

	public WebElement getBirthCountry() {
		return BirthCountry;
	}

	public WebElement getBirthDate() {
		return BirthDate;
	}

	public WebElement getBirthDateUIDatePickerYear() {
		return BirthDateUIDatePickerYear;
	}

	public WebElement getBirthDatePickerDay() {
		return BirthDatePickerDay;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getMail() {
		return Mail;
	}

	public WebElement getPhone() {
		return Phone;
	}

	public WebElement getResidenceCity() {
		return ResidenceCity;
	}

	public WebElement getStreet() {
		return Street;
	}

	public WebElement getHouseNumber() {
		return HouseNumber;
	}

	public WebElement getTextHouseLetter() {
		return TextHouseLetter;
	}

	public WebElement getZipCode() {
		return ZipCode;
	}

	public WebElement getNextButton() {
		return NextButton;
	}

}
