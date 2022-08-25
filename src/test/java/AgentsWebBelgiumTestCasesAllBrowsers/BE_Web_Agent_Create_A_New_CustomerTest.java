package AgentsWebBelgiumTestCasesAllBrowsers;

import java.time.Duration;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AgentsWebObjectRepository.LoginPage;
import AgentsWebObjectRepository.TestBase;
import AllureListener.AllureListenerAgentsWeb;
import Methods.randomMailGenerator;
import Methods.randomNumberGenarator;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({ AllureListenerAgentsWeb.class })
public class BE_Web_Agent_Create_A_New_CustomerTest extends TestBase {

	randomNumberGenarator RndmNmb = new randomNumberGenarator();
	randomMailGenerator RndmMail = new randomMailGenerator();

	@Test
	@Severity(SeverityLevel.NORMAL)
	public void BE_Web_Agent_Create_A_New_Customer_Test() throws Exception {
		// TODO Auto-generated method stub

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://agents-pre-be.moneytrans.eu/Login.aspx");

		// LOGIN
		LoginPage LP = new LoginPage(driver);
		LP.LogInFunction();
		LP.Customers().click();
		LP.NewCustomer().click();
		Thread.sleep(4000);

		// SWITCH TO WINDOW
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);

				////////////////////////////// SENDER MODULE //////////////////////////////////

				// FIRST NAME
				WebElement First_Name = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"txtFirstName\"]")));
				String rs1 = RandomStringUtils.randomAlphabetic(6);
				First_Name.sendKeys(rs1);

				// LAST NAME
				WebElement Last_Name = driver.findElement(By.xpath("//input[@id=\"txtLastName\"]"));
				String rs2 = RandomStringUtils.randomAlphabetic(6);
				Last_Name.sendKeys(rs2);

				// ID NUMBER
				driver.findElement(By.id("txtNumDoc")).sendKeys("43424");

				// ID TYPE
				driver.findElement(By.id("dropdownListTypeDoc")).click();
				driver.findElement(By.id("dropdownListTypeDoc")).sendKeys("Passport");
				driver.findElement(By.id("dropdownListTypeDoc")).sendKeys(Keys.ENTER);

				// EXPIRY DATE
				driver.findElement(By.xpath("//input[@id=\"txtValidityDate\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.cssSelector(".ui-datepicker-year")).click();
				driver.findElement(By.cssSelector(".ui-datepicker-year")).sendKeys("2023");
				driver.findElement(By.cssSelector(".ui-datepicker-year")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()=\"14\"]")).click();
				Thread.sleep(1000);

				// DELIVERY DATE
				driver.findElement(By.xpath("//input[@id=\"txtDeliveryDate\"]")).click();
				driver.findElement(By.xpath("//a[text()=\"4\"]")).click();

				// DELIVERY COUNTRY
				driver.findElement(By.id("dropDownListDeliveryCountry")).click();
				driver.findElement(By.id("dropDownListDeliveryCountry")).sendKeys("Belgium");
				Thread.sleep(1000);
				driver.findElement(By.id("dropDownListDeliveryCountry")).sendKeys(Keys.ENTER);

				// DELIVERY CITY
				driver.findElement(By.id("dropDownListDeliveryCity")).click();
				driver.findElement(By.id("dropDownListDeliveryCity")).sendKeys("Gent");
				Thread.sleep(6000);
				driver.findElement(By.id("dropDownListDeliveryCity")).sendKeys(Keys.ENTER);

				// OCCUPATION
				driver.findElement(By.id("dropdownOccupation")).click();
				driver.findElement(By.id("dropdownOccupation")).sendKeys("Retired");
				Thread.sleep(1000);
				driver.findElement(By.id("dropdownOccupation")).sendKeys(Keys.ENTER);

				// BIRTH COUNTRY
				driver.findElement(By.id("comboNationality")).click();
				driver.findElement(By.id("comboNationality")).sendKeys("Germany");
				Thread.sleep(1000);
				driver.findElement(By.id("comboNationality")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);

				// BIRTH DATE
				WebElement Birth_Date = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtBirthDate")));
				Birth_Date.click();
				driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")).click();
				driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")).sendKeys("1990");
				driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]")).sendKeys(Keys.ENTER);
				driver.findElement(By.xpath("//a[text()=\"4\"]")).click();
				Thread.sleep(2000);

				// GENDER
				driver.findElement(By.id("radioReceiverMale")).click();

				// EMAIL
				WebElement Mail = driver.findElement(By.id("txtMail"));
				String Email = (RndmMail.getSaltString() + "@gmail.com");
				Mail.sendKeys(Email);

				// TELEPHONE
				WebElement Phone = driver.findElement(By.id("txtTelephone"));
				Phone.sendKeys(RndmNmb.createRandomNumber(10));

				// STREET
				driver.findElement(By.id("txtStreet")).sendKeys("Brooklyn");

				// HOUSE NUMBER
				driver.findElement(By.id("txtHouseNumber")).sendKeys("0315");

				// TEXT HOUSE LETTER
				driver.findElement(By.id("txtHouseLetter")).sendKeys("15");

				// ZIP CODE
				driver.findElement(By.id("txtPostalCode")).sendKeys("4352");

				// COUNTRY
				driver.findElement(By.id("DropdownListCountry")).sendKeys("Belgium");
				Thread.sleep(3000);
				driver.findElement(By.id("DropdownListCountry")).sendKeys(Keys.ENTER);

				// RESIDENCE CITY
				driver.findElement(By.id("DropdownListCity")).sendKeys("Gent");
				Thread.sleep(3000);
				driver.findElement(By.id("DropdownListCity")).sendKeys(Keys.ENTER);

				// Province/State
				driver.findElement(By.id("DropDownListProvinceState")).sendKeys("Province");
				Thread.sleep(3000);
				driver.findElement(By.id("DropDownListProvinceState")).sendKeys(Keys.ENTER);

				// New Button Click
				driver.findElement(By.id("btnNewCustomer")).click();

				// Validation
				WebElement Message = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//p[text()=\"The data has been succesfully updated.\"]")));

				Assert.assertEquals(Message.isDisplayed(), true);

			}

		}

	}
}
