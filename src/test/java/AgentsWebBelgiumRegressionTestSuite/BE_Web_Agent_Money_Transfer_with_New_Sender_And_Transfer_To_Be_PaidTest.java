package AgentsWebBelgiumRegressionTestSuite;

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
public class BE_Web_Agent_Money_Transfer_with_New_Sender_And_Transfer_To_Be_PaidTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Web_Agent_Money_Transfer_with_New_Customer_And_Transfer_To_Be_Paid_Test() throws Exception {
		// TODO Auto-generated method stub

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

		// TRANSFERS SCREEN
		DestinationAmountsModulePage DestinationModule = new DestinationAmountsModulePage(driver);
		DestinationModule.getTransfers().click();
		DestinationModule.getTransfersList().click();
		DestinationModule.getSearchButton().click();
		driver.findElement(By.xpath("(//td[text()=\"S\"])[1]")).click();
		DestinationModule.getViewDetailsButton().click();

		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		String URN_Number = driver.findElement(By.xpath("//*[@id=\"txtURN\"]")).getAttribute("value");
		System.out.println(URN_Number);
		driver.close();

		SwitchWindow.SwitchBackToParentWindowMethod(driver);
		Thread.sleep(18000);

		// SEARCH TRANSFER TO BE PAID
		driver.findElement(By.xpath("//a[text()=\"Search transfer to be paid\"]")).click();

		// MINIDRIVER
		WebElement minidriver = driver.findElement(By.id("mainSearchScreen"));

		// TRANSACTION CODE
		minidriver.findElement(By.id("ctl00_PagesContainer_txtTransaction")).sendKeys(URN_Number);

		// AMOUTH TO BE PAID
		minidriver.findElement(By.id("ctl00_PagesContainer_txtAmount")).sendKeys("10");

		// SEARCH
		minidriver.findElement(By.id("ctl00_PagesContainer_btnSearch")).click();

		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		driver.switchTo().alert().accept();

		// EDIT
		driver.findElement(By.id("btnEditReceiver")).click();

		// PLANNED USE OF THE FUNDS
		driver.findElement(By.id("dropDownUseOfFunds")).click();
		driver.findElement(By.id("dropDownUseOfFunds")).sendKeys("Rent");
		driver.findElement(By.id("dropDownUseOfFunds")).sendKeys(Keys.ENTER);

		// PAY TRANSFER
		driver.findElement(By.id("btnToPay")).click();

		// PAY TRANSFER ACCEPT
		driver.findElement(By.id("btnAcceptPay")).click();

		// CONTINUE BUTTON
		driver.findElement(By.cssSelector("input#fraudControls_btnNext")).click();
		driver.findElement(By.cssSelector("input#fraudControls_reasons_0")).click();
		driver.findElement(By.cssSelector("input#fraudControls_btnContinue")).click();
		Thread.sleep(30000);

		// Come back to the parent window
		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// CANCEL
		driver.findElement(By.id("ctl00_PagesContainer_btnCancel")).click();

		// SEARCH
		driver.findElement(By.id("ctl00_PagesContainer_btnSearch")).click();

		// VALIDATE IF "PAID" VISIBLE
		WebElement Paid = driver.findElement(By.xpath("(//td[text()=\"Paid\"])[1]"));

		Assert.assertEquals(Paid.isDisplayed(), true);

	}

}
