package AgentsWebBelgiumTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.ReceiverModuleBelgium;
import AgentsWebModules.SenderModuleBelgium;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.DropdownULLITypeSelection;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Money_Transfer_with_New_Customer_Pin_Cards extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test(enabled = false)
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Web_Agent_Money_Transfer_with_New_Customer() throws Exception {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30, 1));
		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunctionBelgiumPinCard();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		SenderModuleBelgium SenderModuleBelgiumTest = new SenderModuleBelgium();
		SenderModuleBelgiumTest.SenderModuleBelgiumTest();

		// RECEIVER MODULE

		ReceiverModuleBelgium ReceiverModuleBelgiumTest = new ReceiverModuleBelgium();
		ReceiverModuleBelgiumTest.ReceiverModuleBelgiumTest();

		// DESTINATION & AMOUNTS MODULE

		// COUNTRY
		Actions action = new Actions(driver);
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);
		DropdownULLITypeSelection DropdownULLISelect = new DropdownULLITypeSelection();
		DropdownULLISelect.DropdownULLITypeSelect("Belgium", DestinationModule.getOptionListButtonCountry(),
				DestinationModule.getoptionListCountry());

		// PAYMENT MODE
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getPaymentMode()));
		action.moveToElement(DestinationModule.getPaymentMode()).click().sendKeys(Keys.ENTER);
		// CITY
		DestinationModule.getCity().click();
		Thread.sleep(1000);
		DestinationModule.getCitySelection().sendKeys("Gent");
		Thread.sleep(1000);
		DestinationModule.getCitySelection().sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		// PAYERS
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getPayersBelgium())).click();
		Thread.sleep(3000);

		// DESTINATION
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getDestination())).click();
		action.moveToElement(DestinationModule.getDestinationSelection()).sendKeys("AD").wait(1000);
		DestinationModule.getDestinationSelection().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// TO SEND AMOUNT
		DestinationModule.getToSendAmount().sendKeys("3");

		// CALCULATE BUTTON
		action.moveToElement(DestinationModule.getCalculateButton()).click().wait(6000);

		// CASH BUTTON
		action.moveToElement(DestinationModule.getCashButton()).click().wait(4000);

		// SEND BUTTON
		SenderModulePage SenderModule = new SenderModulePage(driver);
		action.moveToElement(SenderModule.getNextButton()).click().wait(6000);

	}
}