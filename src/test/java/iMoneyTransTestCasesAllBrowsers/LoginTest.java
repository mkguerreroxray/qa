package iMoneyTransTestCasesAllBrowsers;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerIMoneyTrans;
import iMoneyTransObjectRepository.LoginPage;
import iMoneyTransObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerIMoneyTrans.class })
public class LoginTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void Login() throws InterruptedException {

		LoginPage LoginP = PageFactory.initElements(driver, LoginPage.class);
		LoginP.LogInFunction();
		Thread.sleep(4000);

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(LoginP.LoginValidation()));
		
		Assert.assertEquals(LoginP.LoginValidation().isDisplayed(), true);
		System.out.println("Successfull Login Attempt");

	}

}
