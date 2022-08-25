package AgentsWebSpainTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.ReceiverModuleSpain;
import AgentsWebModules.SenderModuleSpain;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.DropdownULLITypeSelection;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class ES_Web_Agent_Money_Transfer_To_Receive_with_New_Sender_New_ReceiverTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void ES_Web_Agent_Money_Transfer_with_New_Customer_Test() throws Exception {

		driver.get("https://agents-pre-es.moneytrans.eu/Login.aspx");

		// LOGIN

		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
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

		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		action.moveToElement(DestinationModule.getDestinationSelection()).sendKeys("GIRO");
		Thread.sleep(1000);
		DestinationModule.getDestinationSelection().sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// TO RECEIVE RADIO BUTTON
		DestinationModule.getToReceiveButton().click();

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

		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// TRANSFERS SCREEN
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();

		String Control = DestinationModule.getControl().getText();
		String Control_1 = "REGNO UNITO";
		System.out.println(Control);
		System.out.println(Control_1);

		Assert.assertEquals(Control, Control_1);
	}

}
