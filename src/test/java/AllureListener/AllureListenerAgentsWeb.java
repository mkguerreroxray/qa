package AllureListener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AgentsWebObjectRepository.TestBase;
import io.qameta.allure.Attachment;

public class AllureListenerAgentsWeb implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {

		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {

		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {

		return message;
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("This test is failed:" + getTestMethodName(iTestResult));
		WebDriver driver = TestBase.driver;
		if (driver instanceof WebDriver) {

			System.out.println("Screenshot captured for the failed test case:" + getTestMethodName(iTestResult));
			saveFailureScreenShot(driver);

		}

		saveTextLog(getTestMethodName(iTestResult) + "test case failed and screenshot taken!");

	}

}
