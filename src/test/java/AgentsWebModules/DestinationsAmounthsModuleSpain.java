package AgentsWebModules;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.TestBase;
import Methods.DropdownULLITypeSelection;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;

public class DestinationsAmounthsModuleSpain extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	public void DestinationsAmounthsModuleSpainTest() throws InterruptedException {

		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);

		// COUNTRY
		DropdownULLITypeSelection DropdownULLISelect = new DropdownULLITypeSelection();
		DropdownULLISelect.DropdownULLITypeSelect("Poland", DestinationModule.getOptionListButtonCountry(),
				DestinationModule.getoptionListCountry());
/*
		// PAYMENT MODE
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getPaymentMode())).click();
		action.moveToElement(DestinationModule.getPaymentMode()).sendKeys(Keys.ENTER);
*/
		// CITY
		DropdownULLISelect.DropdownULLITypeSelect("Poznan", DestinationModule.getOptionListButtonCity(),
				DestinationModule.getOptionListCity());
		Thread.sleep(5000);

		// PAYERS
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getPayersBelgium())).click();
		Thread.sleep(3000);

		// DESTINATION
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getDestination())).click();
		action.moveToElement(DestinationModule.getDestinationSelection()).sendKeys("GIRO");
		Thread.sleep(1000);
		DestinationModule.getDestinationSelection().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// TO SEND AMOUNT
		DestinationModule.getToSendAmount().sendKeys("3");
		Thread.sleep(2000);

		// CALCULATE BUTTON
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DestinationModule.getCalculateButton());
		Thread.sleep(6000);

		// CASH
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DestinationModule.getCashButton());

		// SEND BUTTON
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getSendButton()));
		DestinationModule.getSendButton().click();

		driver.close();

	}

}
