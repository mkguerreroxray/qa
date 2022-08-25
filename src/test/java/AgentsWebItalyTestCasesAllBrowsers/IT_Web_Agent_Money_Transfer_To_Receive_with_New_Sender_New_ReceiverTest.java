package AgentsWebItalyTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.ReceiverModuleItaly;
import AgentsWebModules.SenderModuleItaly;
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
public class IT_Web_Agent_Money_Transfer_To_Receive_with_New_Sender_New_ReceiverTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void IT_Web_Agent_Money_Transfer_with_New_Customer_Test() throws Exception {

		driver.get("https://agents-pre-it.moneytrans.eu/Login.aspx");

		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		SenderModuleItaly SenderModuleItalyTest = new SenderModuleItaly();
		SenderModuleItalyTest.SenderModuleItalyTest();

		// RECEIVER MODULE

		ReceiverModuleItaly ReceiverModuleItalyTest = new ReceiverModuleItaly();
		ReceiverModuleItalyTest.ReceiverModuleItalyTest();

		// DESTINATION & AMOUNTS MODULE

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

		// TO RECEIVE RADIO BUTTON
		DestinationModule.getToReceiveButton().click();

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

		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// TRANSFERS SCREEN
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();

		String Control = DestinationModule.getControl().getText();
		String Control_1 = "ITALIA";
		System.out.println(Control);
		System.out.println(Control_1);

		Assert.assertEquals(Control, Control_1);

	}

}
