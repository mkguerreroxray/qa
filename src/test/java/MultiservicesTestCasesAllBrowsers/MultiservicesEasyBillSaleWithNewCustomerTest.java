package MultiservicesTestCasesAllBrowsers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureListener.AllureListenerMultiServices;
import MultiservicesObjectRepository.TestBase;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerMultiServices.class })
public class MultiservicesEasyBillSaleWithNewCustomerTest extends TestBase {
	@Test
	@Severity(SeverityLevel.CRITICAL)
	public void BE_Multiservices_Easy_Bill_Sale_with_New_Customer_Test() throws Exception {

		// LOGIN
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement Username = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='User name (login)']")));
		Username.sendKeys("product");
		WebElement Password = driver.findElement(By.xpath(
				"//*[@id=\"login-wrapper\"]/div[2]/form/nz-form-item[2]/nz-form-control/div/span/nz-input-group/input"));
		Password.sendKeys("test");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		// EASY BILL
		WebElement Easy_Bill = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\" Easy Bill \"]")));
		Easy_Bill.click();
		WebElement Create_New_Customer = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Create new customer ']")));
		Create_New_Customer.click();
		Thread.sleep(1000);

		// FISRT NAME
		driver.findElement(By.cssSelector("input#input.form-control.ng-touched.ng-pristine.ng-invalid"))
				.sendKeys("Automation");
		Thread.sleep(1000);

		// LAST NAME
		driver.findElement(By.xpath("(//*[@id=\"input\"])[2]")).sendKeys("Automation");
		Thread.sleep(1000);

		// DATE OF BIRTH
		driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("12121993", Keys.ENTER);
		Thread.sleep(1000);

		// GENDER
		driver.findElement(By.xpath("//div[@class=\"options\"]/label[1]/span")).click();

		// PHONE
		driver.findElement(By.xpath("(//input[@type=\"tel\"])")).sendKeys("55555555");

		// EMAIL
		driver.findElement(By.xpath("(//input[@type=\"email\"])")).sendKeys("fguler@moneytrans.eu");

		// BIRTH COUNTRY
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Germany']")).click();
		Thread.sleep(1000);

		// NUMBER
		driver.findElement(By.xpath("(//input[@id=\"input\"])[5]")).sendKeys("55555");

		// LETTER
		driver.findElement(By.xpath("(//input[@id=\"input\"])[6]")).sendKeys("55555");

		// ADDRESS
		driver.findElement(By.xpath("(//input[@id=\"input\"])[7]")).sendKeys("Automation");

		// CITY
		driver.findElement(By.xpath("(//input[@type=\"text\"])[10]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[10]")).sendKeys("Bru", Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[10]")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		// ID DOCUMENT TYPE
		driver.findElement(By.xpath("(//div[text()=' Select '])[1]")).click();
		driver.findElement(By.xpath("//li[text()=' Passport ']")).click();

		// DELIVERY DATE
		driver.findElement(By.xpath("(//input[@type=\"text\"])[11]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[11]")).sendKeys("12122020", Keys.ENTER);

		// DElIVERY COUNTRY
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class=\"ng-input\"])[4]/input")).sendKeys("Germany", Keys.ENTER);
		Thread.sleep(1000);

		// ID NUMBER
		driver.findElement(By.xpath("(//input[@id=\"input\"])[8]")).sendKeys("55555");

		// EXPIRATION DATE
		driver.findElement(By.xpath("(//input[@type=\"text\"])[14]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type=\"text\"])[14]")).sendKeys("10102023", Keys.ENTER);
		Thread.sleep(1000);

		// NATIONAL ID
		driver.findElement(By.xpath("(//input[@id=\"input\"])[9]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@id=\"input\"])[9]")).sendKeys("55555555555");
		Thread.sleep(1000);

		// ORIGIN OF FUNDS

		driver.findElement(By.xpath("(//div[@class=\"single ng-star-inserted\"])[3]")).click();

		List<WebElement> list1 = driver.findElements(By.xpath("(//div[@class=\"options\"])[2]/ul/li/span"));

		for (WebElement elm : list1) {

			String check = elm.getText();

			if (check.equalsIgnoreCase("Salary")) {

				elm.click();
				break;
			}

		}

		// OCCUPATION
		driver.findElement(By.xpath("(//div[@class=\"single ng-star-inserted\"])[4]")).click();

		List<WebElement> list2 = driver.findElements(By.xpath("(//div[@class=\"options\"])[2]/ul/li/span"));

		for (WebElement elm : list2) {

			String check = elm.getText();

			if (check.equalsIgnoreCase("Student")) {

				elm.click();
				break;
			}

		}

		// SUSPICIOUS BEHAVIOR
		driver.findElement(By.xpath("(//div[@class=\"single ng-star-inserted\"])[5]")).click();

		List<WebElement> list3 = driver.findElements(By.xpath("(//div[@class=\"options\"])[2]/ul/li/span"));

		for (WebElement elm : list3) {

			String check = elm.getText();

			if (check.equalsIgnoreCase("No")) {

				elm.click();
				break;
			}

		}

		// ID DOCUMENT SCAN

		// SCAN SCREEN OPERATIONS

		// SCAN BUTTON
		driver.findElement(By.xpath("(//button[@class=\"btn scan-button btn-primary\"])[1]")).click();
		Thread.sleep(10000);

		// Get all opened windows list
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		// print the count of windows
		System.out.println(tabs.size());

		// Now you can switch into desired window in your case you want to switch into
		// 3rd one so you have to pass the index 2 as it started from 0
		driver.switchTo().window((String) tabs.get(1));

		WebElement ID_Document_Images = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Identification Document Images\"]")));
		ID_Document_Images.click();
		Thread.sleep(2000);
		ID_Document_Images.click();
		Thread.sleep(2000);

		// UPLOAD FRONT AND BACK ID FILE

		// Front ID
		WebElement fileInputFront = driver.findElement(By.xpath("//*[@id=\"front-wrapper\"]/form/div/button[2]"));
		fileInputFront.click();
		Thread.sleep(2000);
		if (browser.equals("IE")) {

			Runtime.getRuntime().exec("C:\\Automation\\FileUploadFrontIE.exe");
		}

		else {

			Runtime.getRuntime().exec("C:\\Automation\\FileFront.exe");
		}
		Thread.sleep(2000);

		// Back ID
		WebElement fileInputBack = driver.findElement(By.xpath("(//button[@class=\"btn btn-default ng-binding\"])[2]"));
		fileInputBack.click();
		Thread.sleep(4000);
		if (browser.equals("IE")) {

			Runtime.getRuntime().exec("C:\\Automation\\FileUploadBackIE.exe");
		}

		else {

			Runtime.getRuntime().exec("C:\\Automation\\FileBack.exe");
		}

		Thread.sleep(2000);
		driver.close();

		// Switch back to original window
		driver.switchTo().window((String) tabs.get(0));

		// PROOF OF ADDRESS SCAN
		driver.findElement(By.xpath("(//button[@class=\"btn scan-button btn-primary\"])[2]")).click();
		Thread.sleep(10000);

		// Get current window
		String currentWindow1 = driver.getWindowHandle();

		// Get all opened windows list
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());

		// print the count of windows
		System.out.println(tabs1.size());

		// Now you can switch into desired window in your case you want to switch into
		// 3rd one so you have to pass the index 2 as it started from 0
		driver.switchTo().window((String) tabs1.get(1));
		Thread.sleep(3000);

		WebElement Other_Documents = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Other Documents\"]")));
		Other_Documents.click();
		Thread.sleep(2000);
		Other_Documents.click();
		Thread.sleep(2000);

		// SCAN SCREEN OPERATIONS
		WebElement fileInputScanAdress = driver.findElement(By.xpath("//a[text()=\"Add file from your computer\"]"));
		fileInputScanAdress.click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Automation\\FileFront.exe");
		Thread.sleep(4000);
		driver.close();

		// Switch back to original window
		driver.switchTo().window(currentWindow1);
		Thread.sleep(2000);

		// SAVE
		driver.findElement(By.xpath("//span[text()=' Save ']")).click();
		Thread.sleep(5000);

		// CONTINUE BUTTON
		driver.findElement(By.xpath("//*[text()=\" Continue \"]")).click();
		Thread.sleep(1000);

		// SEARCH COMPANY / IBAN
		driver.findElement(By.xpath("//span[text()=' Search Company / IBAN ']")).click();
		Thread.sleep(1000);
		WebElement Modal_Box = driver.findElement(
				By.xpath("//div[@class=\"modal-dialog\"]/div/div/div/div/div/lib-mt-search-input/div/input"));
		Modal_Box.sendKeys("Santander");

		driver.findElement(
				By.xpath("//div[@class=\"modal-dialog\"]/div/div/div/div/div/lib-mt-search-input/div/div/button"))
				.click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class=\"modal-dialog\"]/div/div/div/div/div/table/tbody/tr/div/td/button"))
				.click();

		// COMMUNICATION
		wait.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//div[@class=\"col-md-6 ng-star-inserted\"]/div/input"))));
		driver.findElement(By.xpath("//div[@class=\"col-md-6 ng-star-inserted\"]/div/input")).click();
		driver.findElement(By.id("freeCommunication")).sendKeys("321423132121412");

		// INVOICES SCAN
		driver.findElement(By.cssSelector(".btn.scan-button.btn-primary")).click();
		Thread.sleep(10000);

		// Get all opened windows list
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

		// Now you can switch into desired window in your case you want to switch into
		// 3rd one so you have to pass the index 2 as it started from 0
		driver.switchTo().window((String) tabs2.get(1));
		Thread.sleep(3000);

		// SCAN SCREEN OPERATIONS
		driver.findElement(By.linkText("Other Documents")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Other Documents")).click();
		Thread.sleep(1000);

		// Front ID
		WebElement fileInput = driver.findElement(By.xpath("//a[text()=\"Add file from your computer\"]"));
		fileInput.click();
		Thread.sleep(2000);
		if (browser.equals("IE")) {

			Runtime.getRuntime().exec("C:\\Automation\\FileUploadFrontIE.exe");
		}

		else {

			Runtime.getRuntime().exec("C:\\Automation\\FileFront.exe");
		}
		Thread.sleep(2000);
		driver.close();

		// Switch back to original window
		driver.switchTo().window(currentWindow1);
		Thread.sleep(2000);

		// CALCULATOR
		driver.findElement(By.xpath("(//input[@type=\"text\"])[19]")).sendKeys("3");
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()=' Calculate ']"))))
				.click();
		Thread.sleep(5000);

		// CONTINUE BUTTON
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("(//span[text()=\" Continue \"])[2]")))).click();
		Thread.sleep(2000);

		// PAY BILL
		driver.findElement(By.xpath("//span[text()=' Pay Bill ']")).click();
		Thread.sleep(1000);

		// OPERATION DONE VALIDATION
		WebElement Text = driver.findElement(By.cssSelector(".done-success.form-subtitle"));
		Assert.assertEquals(Text.isDisplayed(), true);

	}

}
