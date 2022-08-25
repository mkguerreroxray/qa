package AgentsWebSpainTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.ReceiverModuleSpain;
import AgentsWebModules.SenderModuleSpain;
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
public class ES_Web_Agent_Money_Transfer_with_New_Sender_Pin_Cards extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test(enabled = true)
	@Severity(SeverityLevel.CRITICAL)
	public void ES_Web_Agent_Money_Transfer_with_New_Customer() throws Exception {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30, 1));
		driver.get("https://agents-pre-es.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunctionSpainPinCard();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		// SWITCH TO WINDOW

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		SenderModuleSpain SenderModuleSpainTest = new SenderModuleSpain();
		SenderModuleSpainTest.SenderModuleSpainTest();

		// RECEIVER MODULE

		ReceiverModuleSpain ReceiverModuleSpainTest = new ReceiverModuleSpain();
		ReceiverModuleSpainTest.ReceiverModuleSpainTest();

		// DESTINATION & AMOUNTS MODULE

		SenderModulePage SenderModule = new SenderModulePage(driver);
		Actions action = new Actions(driver);
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);

		// COUNTRY
		DropdownULLITypeSelection DropdownULLISelect = new DropdownULLITypeSelection();
		DropdownULLISelect.DropdownULLITypeSelect("Poland", DestinationModule.getOptionListButtonCountry(),
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
		action.moveToElement(DestinationModule.getDestinationSelection()).sendKeys("GIRO").wait(1000);
		DestinationModule.getDestinationSelection().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// TO SEND AMOUNT
		DestinationModule.getToSendAmount().sendKeys("3");

		// CALCULATE BUTTON
		action.moveToElement(DestinationModule.getCalculateButton()).click().wait(6000);

		// CASH
		action.moveToElement(DestinationModule.getCashButton()).click().wait(4000);

		// SEND BUTTON
		action.moveToElement(SenderModule.getNextButton()).click().wait(6000);

	}
}
