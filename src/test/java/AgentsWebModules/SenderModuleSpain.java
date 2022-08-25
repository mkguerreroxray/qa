package AgentsWebModules;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import Methods.DropDownSelection;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;

public class SenderModuleSpain extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	public void SenderModuleSpainTest() throws InterruptedException, IOException {

		SenderModulePage SenderModule = new SenderModulePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// FIRST NAME
		wait.until(ExpectedConditions.elementToBeClickable(SenderModule.getFirstName()));
		String rs1 = RandomStringUtils.randomAlphabetic(6);
		SenderModule.getFirstName().sendKeys(rs1);

		// LAST NAME
		wait.until(ExpectedConditions.elementToBeClickable(SenderModule.getLastName()));
		String rs2 = RandomStringUtils.randomAlphabetic(6);
		SenderModule.getLastName().sendKeys(rs2);

		// ID NUMBER
		SenderModule.getIDNumber().sendKeys("55555");

		// SCAN
		SenderModule.getScanButton().click();
		Thread.sleep(10000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewSecondWindowMethod(driver);
		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(SenderModule.getID_Document_Images())).click();
		Thread.sleep(2000);

		SenderModule.getID_Document_Images().click();
		Thread.sleep(2000);

		SenderModule.getFileInputFront().click();
		Thread.sleep(2000);

		if (browser.equals("IE")) {

			Runtime.getRuntime().exec("C:\\Automation\\FileUploadFrontIE.exe");
		}

		else {

			Runtime.getRuntime().exec("C:\\Automation\\FileFront.exe");
		}
		Thread.sleep(2000);

		SenderModule.getFileInputBack().click();
		Thread.sleep(2000);

		if (browser.equals("IE")) {

			Runtime.getRuntime().exec("C:\\Automation\\FileUploadBackIE.exe");
		}

		else {

			Runtime.getRuntime().exec("C:\\Automation\\FileBack.exe");
		}

		Thread.sleep(4000);
		driver.close();

		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// EDIT ID DATA
		try {

			wait.until(ExpectedConditions.elementToBeClickable(SenderModule.getEditIDData())).click();

		}

		catch (org.openqa.selenium.StaleElementReferenceException e) {

			SenderModule.getEditIDData2().click();
		}

		Thread.sleep(2000);

		SenderModule.getEditIDDataFirstName().clear();

		SenderModule.getEditIDDataFirstName().sendKeys(rs1);
		Thread.sleep(1000);

		SenderModule.getEditIDDataLastName().clear();

		SenderModule.getEditIDDataLastName().sendKeys(rs2);
		Thread.sleep(1000);

		SenderModule.getEditIDDataDeliveryCountry().sendKeys("Poland");
		Thread.sleep(1000);

		SenderModule.getEditIDDataDeliveryCountry().sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		SenderModule.getEditIDDataDocNumber().clear();

		SenderModule.getEditIDDataDocNumber().sendKeys(RndmNmb.createRandomNumber(8));
		Thread.sleep(1000);

		SenderModule.getEditIDDataContinueButton().click();
		Thread.sleep(5000);

		// DELIVERY CITY
		wait.until(ExpectedConditions.elementToBeClickable(SenderModule.getDeliveryCity())).click();
		SenderModule.getDeliveryCity().sendKeys("Poznan");
		Thread.sleep(6000);
		SenderModule.getDeliveryCity().sendKeys(Keys.ENTER);

		DropDownSelection DropDownSelect = new DropDownSelection();

		// OCCUPATION
		DropDownSelect.DropdownListSelect(SenderModule.getOccupation(), "Retired/Pensioner");

		// SOURCE OF FUNDS
		DropDownSelect.DropdownListSelect(SenderModule.getSourceOfFunds(), "Gift");

		// PURPOSE OF TRANSACTION
		DropDownSelect.DropdownListSelect(SenderModule.getPurposeOfTransaction(), "Gift");

		// BIRTH COUNTRY
		DropDownSelect.DropdownListSelect(SenderModule.getBirthCountry(), "Germany");

		// EMAIL
		String Email = (RndmMail.getSaltString() + "@gmail.com");
		SenderModule.getMail().sendKeys(Email);

		// TELEPHONE
		SenderModule.getPhone().sendKeys(RndmNmb.createRandomNumber(10));

		// RESIDENCE CITY
		SenderModule.getResidenceCity().sendKeys("Madrid");
		Thread.sleep(3000);
		SenderModule.getResidenceCity().sendKeys(Keys.ENTER);

		// STREET
		SenderModule.getStreet().sendKeys("Brooklyn");

		// HOUSE NUMBER
		SenderModule.getHouseNumber().sendKeys("0315");

		// TEXT HOUSE LETTER
		SenderModule.getTextHouseLetter().sendKeys("15");

		// ZIP CODE
		SenderModule.getZipCode().sendKeys("4352");

		// NEXT BUTTON
		SenderModule.getNextButton().click();

	}

}
