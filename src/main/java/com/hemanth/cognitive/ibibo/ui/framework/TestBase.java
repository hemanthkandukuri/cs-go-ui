package com.hemanth.cognitive.ibibo.ui.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

/**
 * @author hkandukuri
 *
 */
public class TestBase {

	private static String BASE_URL = "";
	public static WebDriver driver;

	@Parameters("base_url")
	@BeforeSuite
	public static void setBaseUrl(String url) {
		BASE_URL = url;
	}

	@Parameters("browser")
	@BeforeTest
	public static void initBrowser(String browser) throws InterruptedException {
		BrowserFactory.StartBrowser(browser);
		Thread.sleep(10000);
		driver = BrowserFactory.getWebDriver();
	}

	@AfterSuite(alwaysRun = true)
	public static void TestClassTearDown() {
		BrowserFactory.Close();
	}

	public static String getBaseURL() {
		return BASE_URL;
	}
}
