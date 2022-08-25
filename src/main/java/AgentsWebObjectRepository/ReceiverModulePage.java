package AgentsWebObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceiverModulePage {

	WebDriver driver;

	public ReceiverModulePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/input[2]")
	WebElement AcceptButtonReceiver;

	public WebElement getAcceptButtonReceiver() {
		return AcceptButtonReceiver;
	}

	@CacheLookup
	@FindBy(xpath = "//*[@id=\"searchCustomersTable_remote\"]/tbody/tr[2]/td[4]")
	WebElement TestUserSelectionReceiver;

	public WebElement getTestUserSelectionReceiver() {
		return TestUserSelectionReceiver;
	}

	@CacheLookup
	@FindBy(name = "ReceiverModule$btnSearchByTelephone")
	WebElement ExistentReceiverSelectionByPhone;

	public WebElement getExistentReceiverSelectionByPhone() {
		return ExistentReceiverSelectionByPhone;
	}
	
	@CacheLookup
	@FindBy(name = "ReceiverModule$btnSearchByReceiverName")
	WebElement ExistentReceiverSelectionByName;
	

	public WebElement getExistentReceiverSelectionByName() {
		return ExistentReceiverSelectionByName;
	}

	@CacheLookup
	@FindBy(id = "btnSearchReceiver")
	WebElement getReceiverSearchButton;

	public WebElement getGetReceiverSearchButton() {
		return getReceiverSearchButton;
	}

	@CacheLookup
	@FindBy(name = "ReceiverModule$txtSearchReceiver")
	WebElement getExistentReceiverTxtSearch;

	public WebElement getGetExistentReceiverTxtSearch() {
		return getExistentReceiverTxtSearch;
	}

	@CacheLookup
	@FindBy(name = "ReceiverModule$txtThelephone")
	WebElement PhoneReceiver;

	public WebElement getPhoneReceiver() {
		return PhoneReceiver;
	}
	
	@CacheLookup
	@FindBy(name = "ReceiverModule$txtFirstName")
	WebElement NameReceiver;
	
	

	public WebElement getNameReceiver() {
		return NameReceiver;
	}

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtFirstName")
	WebElement FirstName;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtLastName")
	WebElement LastName;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtNumDoc")
	WebElement IDNumber;

	@CacheLookup
	@FindBy(id = "ReceiverModule_DropdownListTypeDoc")
	WebElement IDType;

	@CacheLookup
	@FindBy(css = "input#ReceiverModule_txtValidityDate")
	WebElement ExpiryDate;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtDeliveryDate")
	WebElement DeliveryDate;

	@CacheLookup
	@FindBy(id = "ReceiverModule_dropDownListDeliveryCountry")
	WebElement DeliveryCountry;

	@CacheLookup
	@FindBy(id = "ReceiverModule_dropDownListCustomerRelationship")
	WebElement RelationshipWithBeneficiary;

	@CacheLookup
	@FindBy(id = "ReceiverModule_comboNationality")
	WebElement BirthCountry;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtBirthDate")
	WebElement BirthDate;

	@CacheLookup
	@FindBy(id = "ReceiverModule_radioSex_0")
	WebElement Gender;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtMail")
	WebElement Email;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtThelephone")
	WebElement Telephone;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtStreet")
	WebElement Street;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtHouseNumber")
	WebElement HouseNumber;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtHouseLetter")
	WebElement TextHouseLetter;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtPostalCode")
	WebElement ZipCode;

	@CacheLookup
	@FindBy(id = "ReceiverModule_AutoCompleteCitySelector_DropdownListCountry")
	WebElement ResidenceCountry;

	@CacheLookup
	@FindBy(id = "ReceiverModule_AutoCompleteCitySelector_txtCitySelector")
	WebElement ResidenceCity;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtThelephone")
	WebElement Phone;

	@CacheLookup
	@FindBy(id = "ReceiverModule_txtSearchReceiver")
	WebElement ExistentReceiver;

	@CacheLookup
	@FindBy(id = "btnSearchReceiver")
	WebElement SearchReceiverButton;

	@CacheLookup
	@FindBy(xpath = "(//td[text()=\"AUTOMATION\"])[1]")
	WebElement SearchReceiver;

	@CacheLookup
	@FindBy(xpath = "(//*[@class=\"searchButton\"])[1]")
	WebElement AcceptButton;

	@CacheLookup
	@FindBy(id = "btnEditReceiver")
	WebElement EditButton;

	@CacheLookup
	@FindBy(name = "ReceiverModule$btnSearchByReceiverName")
	WebElement SearchByReceiverNameButton;

	public WebElement getSearchByReceiverNameButton() {
		return SearchByReceiverNameButton;
	}

	public WebElement getEditButton() {
		return EditButton;
	}

	public WebElement getAcceptButton() {
		return AcceptButton;
	}

	public WebElement getSearchReceiver() {
		return SearchReceiver;
	}

	public WebElement getExistentReceiver() {
		return ExistentReceiver;
	}

	public WebElement getSearchReceiverButton() {
		return SearchReceiverButton;
	}

	public WebElement getPhone() {
		return Phone;
	}

	public WebElement getResidenceCity() {
		return ResidenceCity;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTelephone() {
		return Telephone;
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

	public WebElement getResidenceCountry() {
		return ResidenceCountry;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getBirthDate() {
		return BirthDate;
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

	public WebElement getIDType() {
		return IDType;
	}

	public WebElement getExpiryDate() {
		return ExpiryDate;
	}

	public WebElement getDeliveryDate() {
		return DeliveryDate;
	}

	public WebElement getDeliveryCountry() {
		return DeliveryCountry;
	}

	public WebElement getRelationshipWithBeneficiary() {
		return RelationshipWithBeneficiary;
	}

	public WebElement getBirthCountry() {
		return BirthCountry;
	}

}
