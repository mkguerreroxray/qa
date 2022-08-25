package MultiservicesTestCasesAllBrowsers;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerMultiServices;
import Methods.SwitchToWindow;
import MultiservicesObjectRepository.HomePage;
import MultiservicesObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerMultiServices.class })
public class MultiservicesEasyBillSaleWithExistentCustomerTest extends TestBase {

	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Multiservices_Easy_Bill_Sale_with_Existent_Customer_Test() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		HomePage Home = new HomePage(driver);

		// LOGIN

		MultiservicesLoginTest MultiservicesLogin = new MultiservicesLoginTest();
		MultiservicesLogin.LoginFunctionMultiservices();

		// EASY BILL
		wait.until(ExpectedConditions.elementToBeClickable(Home.getEasyBill()));
		Home.getEasyBill().click();

		wait.until(ExpectedConditions.elementToBeClickable(Home.getEnterCustomerName()));
		Home.getEnterCustomerName().sendKeys("Automation");

		// SELECTING EXISTENT CUSTOMER
		wait.until(ExpectedConditions.elementToBeClickable(Home.getSelectCustomer()));
		Home.getSelectCustomer().click();
		Thread.sleep(3000);

		// CONTINUE BUTTON
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.elementToBeClickable(Home.getContinueButton()));
		executor.executeScript("arguments[0].click();", Home.getContinueButton());

		// SEARCH COMPANY / IBAN
		Home.getSearchCompanyIban().click();

		Home.getModalBox().sendKeys("Santander", Keys.ENTER);
		Thread.sleep(5000);

		wait.until(ExpectedConditions.elementToBeClickable(Home.getSelectCustomerLast()));
		Home.getSelectCustomerLast().click();

		// COMMUNICATION
		Home.getFreeCommunicationRadioButton().click();
		Home.getFreeCommunicationTextBox().sendKeys("321423132121412");

		// INVOICES SCAN
		Home.getInvoiceScan().click();
		Thread.sleep(4000);

		SwitchToWindow SwitchWindow = new SwitchToWindow();
		SwitchWindow.SwitchToNewFirstWindowMethod(driver);

		// SCAN SCREEN OPERATIONS
		wait.until(ExpectedConditions.elementToBeClickable(Home.getOtherDocuments()));
		Home.getOtherDocuments().click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(Home.getOtherDocuments()));
		Home.getOtherDocuments().click();
		Thread.sleep(3000);

		// Front ID
		wait.until(ExpectedConditions.elementToBeClickable(Home.getFrontID()));
		Home.getFrontID().click();
		Thread.sleep(3000);

		if (browser.equals("IE")) {

			Runtime.getRuntime().exec("C:\\Automation\\FileUploadFrontIE.exe");
		}

		else {

			Runtime.getRuntime().exec("C:\\Automation\\FileFront.exe");
		}

		Thread.sleep(3000);

		driver.close();

		Thread.sleep(2000);

		// Switch back to original window
		SwitchWindow.SwitchBackToParentWindowMethod(driver);

		// CALCULATOR
		wait.until(ExpectedConditions.elementToBeClickable(Home.getCalculator()));
		executor.executeScript("arguments[0].click();", Home.getCalculator());
		Home.getCalculator().sendKeys("3");
		Thread.sleep(3000);

		Home.getCalculate().click();
		Thread.sleep(3000);

		// CONTINUE BUTTON
		Home.getContinueLast().click();

		// CONFIRMATION
		wait.until(ExpectedConditions.elementToBeClickable(Home.getPayBill()));
		Home.getPayBill().click();

		// OPERATION DONE VALIDATION
		wait.until(ExpectedConditions.elementToBeClickable(Home.getOperationDoneValidation()));
		Assert.assertEquals(Home.getOperationDoneValidation().isDisplayed(), true);

	}

}
