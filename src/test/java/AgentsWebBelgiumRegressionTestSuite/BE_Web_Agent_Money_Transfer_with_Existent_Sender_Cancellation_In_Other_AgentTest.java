package AgentsWebBelgiumRegressionTestSuite;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.ReceiverModuleBelgium;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.DropDownSelection;
import Methods.DropdownULLITypeSelection;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Money_Transfer_with_Existent_Sender_Cancellation_In_Other_AgentTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Web_Agent_Money_Transfer_with_New_Customer() throws Exception {

		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SENDER MODULE

		// EXISTENT CUSTOMER SELECTION
		SenderModulePage SenderModule = new SenderModulePage(driver);
		SenderModule.getExistentCustomerSelectionByName().click();
		SenderModule.getExistentCustomerTxtSearch().sendKeys("automation");
		SenderModule.getExistentCustomerSearchButton().click();
		Thread.sleep(5000);

		// TEST USER SELECTION
		List<WebElement> existentSenders = SenderModule.getExistentSenders();

		int i = existentSenders.size();

		WebElement existentSender = SenderModule.getExistentSenders().get(i - 1);
		existentSender.click();

		// ACCEPT BUTTON
		SenderModule.getAcceptButton().click();
		Thread.sleep(5000);

		// EDIT BUTTON
		SenderModule.getEditButton().click();
		Thread.sleep(4000);

		DropDownSelection DropDownSelect = new DropDownSelection();

		// SOURCE OF FUNDS
		DropDownSelect.DropdownListSelect(SenderModule.getSourceOfFunds(), "Gift");

		// PURPOSE OF TRANSACTION
		DropDownSelect.DropdownListSelect(SenderModule.getPurposeOfTransaction(), "Gift");

		// NEXT BUTTON
		SenderModule.getNextButton().click();

		// RECEIVER MODULE
		ReceiverModuleBelgium ReceiverModuleBelgiumTest = new ReceiverModuleBelgium();
		ReceiverModuleBelgiumTest.ReceiverModuleBelgiumTest();

		// DESTINATION & AMOUNTS MODULE
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);

		// COUNTRY
		DropdownULLITypeSelection DropdownULLISelect = new DropdownULLITypeSelection();
		DropdownULLISelect.DropdownULLITypeSelect("Belgium", DestinationModule.getOptionListButtonCountry(),
				DestinationModule.getoptionListCountry());
		Thread.sleep(4000);

		// CITY
		DropdownULLISelect.DropdownULLITypeSelect("Gent", DestinationModule.getOptionListButtonCity(),
				DestinationModule.getOptionListCity());
		Thread.sleep(5000);

		// PAYERS
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getPayersBelgium()));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", DestinationModule.getPayersBelgium());

		// DESTINATION
		DestinationModule.getDestination().click();
		Thread.sleep(2000);

		// TO SEND AMOUNT
		DestinationModule.getToSendAmount().sendKeys("3");
		Thread.sleep(2000);

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
/*
		// INFORMATION
		wait.until(ExpectedConditions.elementToBeClickable(DestinationModule.getContinueButton()));
		DestinationModule.getContinueButton().click();
		DestinationModule.getReasonsRadioButton().click();
		DestinationModule.getSendInformationButton().click();
*/
		driver.close();

		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// LOG OUT
		DestinationAmountsModulePage DestinationAmountsModule = new DestinationAmountsModulePage(driver);
		DestinationAmountsModule.getLogOut().click();
		DestinationAmountsModule.getLogOutSubOption().click();

		// LOGIN
		// LP.LogInFunctionOtherAgent();
		driver.findElement(By.id("txtUser")).sendKeys("fguler");
		driver.findElement(By.id("txtPassword")).sendKeys("Asd.12547970.", Keys.ENTER);

		// TRANSFERS SCREEN
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();
		DestinationModule.getViewDetailsButton().click();

		// SWITCH TO WINDOW
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// CANCEL TRANSFER
		driver.findElement(By.cssSelector("input#btnAccessCancelTransaction")).click();

		// CANCELLATION REASON
		driver.findElement(By.cssSelector("textarea#txbReason")).sendKeys("Testing purpose.");
		driver.findElement(By.cssSelector("input#btnActionCancelTransaction")).click();
		Thread.sleep(5000);
		driver.close();

		// Come back to the parent window
		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// Refresh The Page
		driver.findElement(By.id("ctl00_PagesContainer_btnSearch")).click();

		// VALIDATE IF "PAID" VISIBLE
		WebElement Cancelled = driver.findElement(By.xpath("(//td[text()=\"Cancelled Immediately\"])[1]"));

		Assert.assertEquals(Cancelled.isDisplayed(), true);

	}

}
