package AgentsWebModules;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.ReceiverModulePage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import Methods.DropDownSelection;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;

public class ReceiverModuleItaly extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	public void ReceiverModuleItalyTest() throws InterruptedException {

		ReceiverModulePage ReceiverModule = new ReceiverModulePage(driver);
		SenderModulePage SenderModule = new SenderModulePage(driver);
		Actions action = new Actions(driver);
		DropDownSelection DropDownSelect = new DropDownSelection();

		// FIRST NAME
		String rs3 = RandomStringUtils.randomAlphabetic(6);
		ReceiverModule.getFirstName().sendKeys(rs3);

		// LAST NAME
		String rs4 = RandomStringUtils.randomAlphabetic(6);
		ReceiverModule.getLastName().sendKeys(rs4);

		// ID NUMBER
		ReceiverModule.getIDNumber().sendKeys("32312314");

		// ID TYPE
		DropDownSelect.DropdownListSelect(ReceiverModule.getIDType(), "Passport");

		// EXPIRY DATE
		ReceiverModule.getExpiryDate().click();
		Thread.sleep(1000);
		action.moveToElement(SenderModule.getUIDatePickerYear()).click().sendKeys("2022", Keys.ENTER);
		Thread.sleep(1000);
		SenderModule.getExpiryDateDay().click();
		Thread.sleep(1000);

		// DELIVERY DATE
		ReceiverModule.getDeliveryDate().click();
		SenderModule.getDeliveryDateDay().click();

		// DELIVERY COUNTRY
		DropDownSelect.DropdownListSelect(ReceiverModule.getDeliveryCountry(), "Germany");

		// RELATIONSHIP WITH BENEFICIARY
		DropDownSelect.DropdownListSelect(ReceiverModule.getRelationshipWithBeneficiary(), "Friend");

		// BIRTH COUNTRY
		DropDownSelect.DropdownListSelect(ReceiverModule.getBirthCountry(), "Germany");

		// BIRTH DATE
		ReceiverModule.getBirthDate().click();
		action.moveToElement(SenderModule.getBirthDateUIDatePickerYear()).click().sendKeys("1990", Keys.ENTER);
		SenderModule.getBirthDatePickerDay().click();
		Thread.sleep(2000);

		// GENDER
		ReceiverModule.getGender().click();

		// EMAIL
		String Email1 = (RndmMail.getSaltString() + "@gmail.com");
		ReceiverModule.getEmail().sendKeys(Email1);

		// TELEPHONE
		ReceiverModule.getPhone().sendKeys(RndmNmb.createRandomNumber(10));

		// STREET
		ReceiverModule.getStreet().sendKeys("Brooklyn");

		// HOUSE NUMBER
		ReceiverModule.getHouseNumber().sendKeys("0315");

		// TEXT HOUSE LETTER
		ReceiverModule.getTextHouseLetter().sendKeys("15");

		// ZIP CODE
		ReceiverModule.getZipCode().sendKeys("43521");

		// RESIDENCE COUNTRY
		DropDownSelect.DropdownListSelect(ReceiverModule.getResidenceCountry(), "Germany");

		// RESIDENCE CITY
		ReceiverModule.getResidenceCity().sendKeys("Berlin");
		Thread.sleep(5000);
		ReceiverModule.getResidenceCity().sendKeys(Keys.ENTER);

		// NEXT BUTTON
		SenderModule.getNextButton().click();

	}

}
