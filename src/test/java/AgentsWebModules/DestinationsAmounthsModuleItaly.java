package AgentsWebModules;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.TestBase;
import Methods.DropdownULLITypeSelection;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;

public class DestinationsAmounthsModuleItaly extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	public void DestinationsAmounthsModuleItalyTest() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);

		// COUNTRY
		DropdownULLITypeSelection DropdownULLISelect = new DropdownULLITypeSelection();
		DropdownULLISelect.DropdownULLITypeSelect("Italy", DestinationModule.getOptionListButtonCountry(),
				DestinationModule.getoptionListCountry());
		Thread.sleep(5000);

		// CITY
		DropdownULLISelect.DropdownULLITypeSelect("Roma", DestinationModule.getOptionListButtonCity(),
				DestinationModule.getOptionListCity());
		Thread.sleep(5000);

		// PAYERS
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DestinationModule.getPayersItaly());
		Thread.sleep(3000);

		// DESTINATION
		DestinationModule.getDestination().click();
		Thread.sleep(3000);

		// TO SEND AMOUNT
		DestinationModule.getToSendAmount().sendKeys("3");

		// CALCULATE BUTTON
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DestinationModule.getCalculateButton());
		Thread.sleep(6000);

		// CASH BUTTON
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DestinationModule.getCashButton());

		// SEND BUTTON
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getSendButton()));
		DestinationModule.getSendButton().click();

		try {

			driver.switchTo().alert().accept();
		} catch (org.openqa.selenium.UnhandledAlertException e) {

			driver.switchTo().alert().dismiss();

		}

		catch (org.openqa.selenium.NoAlertPresentException e)

		{
			System.out.println("No alert present.");

		}

		driver.close();

	}

}
