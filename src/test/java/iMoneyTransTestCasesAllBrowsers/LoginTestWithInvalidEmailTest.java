package iMoneyTransTestCasesAllBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import iMoneyTransObjectRepository.LoginPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({AllureListenerIMoneyTrans.class})
public class LoginTestWithInvalidEmailTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void LoginTestWithInvalidEmailTesting() throws InterruptedException {

		LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);
		LoginP.InvalidLogInFunction();
		Thread.sleep(4000);

		String Expected = driver.findElement(By.xpath("//span[@id=\"error-msg\"]")).getAttribute("innerHTML");
		Assert.assertEquals("Invalid email address", Expected);
		System.out.println("Invalid Login Attempt");

	}

}
