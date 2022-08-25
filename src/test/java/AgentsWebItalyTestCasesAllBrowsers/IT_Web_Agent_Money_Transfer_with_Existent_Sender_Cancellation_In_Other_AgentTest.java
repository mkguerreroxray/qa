package AgentsWebItalyTestCasesAllBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationsAmounthsModuleItaly;
import AgentsWebModules.ReceiverModuleItaly;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.SenderModulePage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.DropDownSelection;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class IT_Web_Agent_Money_Transfer_with_Existent_Sender_Cancellation_In_Other_AgentTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void IT_Web_Agent_Money_Transfer_with_New_Customer() throws Exception {
		// TODO Auto-generated method stub

		driver.get("https://agents-pre-it.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.NewTransfer().click();
		Thread.sleep(4000);

		// SWITCH TO WINDOW
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
		SenderModule.getTestUserSelectionItaly().click();
		Thread.sleep(2000);

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

		// SUSPICIOUS BEHAVIOUR
		DropDownSelect.DropdownListSelect(SenderModule.getSuspiciousBehaviour(), "No");

		// NEXT BUTTON
		SenderModule.getNextButton().click();

		// RECEIVER MODULE
		ReceiverModuleItaly ReceiverModuleItalyTest = new ReceiverModuleItaly();
		ReceiverModuleItalyTest.ReceiverModuleItalyTest();

		// DESTINATION & AMOUNTS MODULE
		DestinationsAmounthsModuleItaly DestinationsAmounthsModuleItalyTest = new DestinationsAmounthsModuleItaly();
		DestinationsAmounthsModuleItalyTest.DestinationsAmounthsModuleItalyTest();

		driver.close();

		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// LOG OUT
		DestinationAmountsModulePage DestinationAmountsModule = new DestinationAmountsModulePage(driver);
		DestinationAmountsModule.getLogOut().click();
		DestinationAmountsModule.getLogOutSubOption().click();
		Thread.sleep(3000);

		// LOGIN
		LP.LogInFunctionOtherAgent();

		// TRANSFERS SCREEN
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);
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
