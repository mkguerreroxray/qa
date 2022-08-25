package MoneytransDesktopApplications;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.windows.WindowsDriver;

public class CentralSpainLogInAndPagesControlTest {

	@SuppressWarnings("rawtypes")
	@Test
	public static void setUp() throws MalformedURLException, InterruptedException {

		// Give the .exe executable file directory to the following section
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app",
				"C:\\Users\\FurkanGuler\\AppData\\Local\\Apps\\2.0\\9QOMZW0R.C9H\\VYH3LPG5.XYC\\mone...app_dde0a054a407f014_0005.000c_512506620ae4c52c\\Moneytrans.Partner.CentralApp.exe");

		capabilities.setCapability("platformName", "Windows");
		capabilities.setCapability("deviceName", "WindowsPC");
		WindowsDriver LoginSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
		LoginSession.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(6000);

		ArrayList<String> NewTab = new ArrayList<String>(LoginSession.getWindowHandles());
		LoginSession.switchTo().window(NewTab.get(0));

		LoginSession.findElementByAccessibilityId("txtUserName").sendKeys("fguler");
		LoginSession.findElementByAccessibilityId("txtPwd").sendKeys("Asd.12547970.");
		LoginSession.findElementByAccessibilityId("btnActionEnter").click();

		WebElement Home = LoginSession.findElementByAccessibilityId("btnAppHome");
		WebElement Agents = LoginSession.findElementByAccessibilityId("btnAppAgents");
		WebElement Banks = LoginSession.findElementByAccessibilityId("btnAppBanks");
		WebElement Products = LoginSession.findElementByAccessibilityId("btnAppProducts");
		WebElement Customers = LoginSession.findElementByAccessibilityId("btnAppCustomers");
		WebElement Policy = LoginSession.findElementByAccessibilityId("btnAppPolicy");
		WebElement Network = LoginSession.findElementByAccessibilityId("btnAppNetwork");
		WebElement Sellers = LoginSession.findElementByAccessibilityId("btnAppSellers");
		WebElement Administration = LoginSession.findElementByAccessibilityId("btnAppAdministration");

		ArrayList<WebElement> Buttons = new ArrayList<WebElement>();

		Buttons.add(Home);
		Buttons.add(Agents);
		Buttons.add(Banks);
		Buttons.add(Products);
		Buttons.add(Customers);
		Buttons.add(Policy);
		Buttons.add(Network);
		Buttons.add(Sellers);
		Buttons.add(Administration);

		Assertion softassert = new SoftAssert();

		WebElement ExcelButton = LoginSession.findElementByAccessibilityId("btnActionExportToExcelINT");
		for (WebElement button : Buttons) {

			button.click();
			softassert.assertEquals(ExcelButton.isDisplayed(), true);

		}
	}

}
