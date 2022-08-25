package AgentsWebObjectRepository;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static String browser = "Chrome";
	public static WebDriver driver = null;

	@BeforeClass
	public void DriverInitialize() {

		if (browser.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("disable-features=NetworkService");
			options.addArguments("disable-gpu");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

		}

		else if (browser.equals("Edge")) {

			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

		}

		else if (browser.equals("IE")) {

			WebDriverManager.iedriver().setup();
			WebDriver driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();

		}
	}

	@AfterClass
	public void TearDown() {

		TestBase.driver.manage().deleteAllCookies();
		TestBase.driver.quit();
	}

}
