package AgentsWebBelgiumTestCasesAllBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebModules.DestinationAmountsModuleBelgium;
import AgentsWebModules.ReceiverModuleBelgium;
import AgentsWebModules.SenderModuleBelgium;
import AgentsWebObjectRepository.DestinationAmountsModulePage;
import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.SwitchToWindow;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Money_Transfer_with_New_Sender_Cancellation_In_Other_AgentTest extends TestBase {

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
		SenderModuleBelgium SenderModuleBelgiumTest = new SenderModuleBelgium();
		SenderModuleBelgiumTest.SenderModuleBelgiumTest();

		// RECEIVER MODULE
		ReceiverModuleBelgium ReceiverModuleBelgiumTest = new ReceiverModuleBelgium();
		ReceiverModuleBelgiumTest.ReceiverModuleBelgiumTest();

		// DESTINATION & AMOUNTS MODULE
		DestinationAmountsModuleBelgium DestinationAmountsModuleBelgiumTest = new DestinationAmountsModuleBelgium();
		DestinationAmountsModuleBelgiumTest.DestinationAmountsModuleBelgiumTest();

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
