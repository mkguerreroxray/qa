package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import Methods.randomNumberGenarator;
import iMoneyTransObjectRepository.MobileTopUpPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListenerIMoneyTrans.class})
public class MobileTopUpEditRecipientTest extends TestBase {

	@Test
	@Severity(SeverityLevel.MINOR)
	public void MobileTopUpEditingRecipientTest() throws InterruptedException {

		LoginTest LogTest = PageFactory.initElements(driver, LoginTest.class);
		LogTest.Login();

		MobileTopUpPage MTUPage = new MobileTopUpPage(driver);
		randomNumberGenarator RndmNmb = new randomNumberGenarator();

		MTUPage.MobileTopUpButton().click();

		MTUPage.Recipients().click();
		Thread.sleep(7000);

		MTUPage.Search().sendKeys("Test Automation");
		Thread.sleep(5000);

		if (MTUPage.RecipientNameConfirmation().isDisplayed() == true) {

			MTUPage.Edit().click();
			Thread.sleep(10000);

		}

		MTUPage.Phone().clear();

		String ExpectedPhone = "+9054" + RndmNmb.createRandomNumber(8);
		MTUPage.Phone().sendKeys(ExpectedPhone);
		Thread.sleep(6000);

		MTUPage.SaveChanges().click();
		Thread.sleep(7000);

		MTUPage.Search().sendKeys("Test Automation");
		Thread.sleep(5000);

		String ActualPhone = MTUPage.PhoneCheck().getAttribute("innerHTML");

		System.out.println(ActualPhone);
		System.out.println(ExpectedPhone);
		Assert.assertEquals(ActualPhone, ExpectedPhone);

	}

}
