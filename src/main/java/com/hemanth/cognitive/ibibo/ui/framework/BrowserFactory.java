package com.hemanth.cognitive.ibibo.ui.framework;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author hkandukuri
 */
public class BrowserFactory {

	private static WebDriver driver;
	private static ResourceBundle bundle = ResourceBundle.getBundle("automation");
	private static Logger log = Logger.getLogger(BrowserFactory.class.getName());

	public static WebDriver StartBrowser(String browserName) {
		if (browserName.equals("firefox")) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			driver = new FirefoxDriver(capabilities);
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", bundle.getString("chromedriver_folder_path"));
			driver = new ChromeDriver();
		} else if (browserName.equals("internet-explorer")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else {
			driver.close();
			log.error("Failed!!\nNo valid browser to launch.");
		}
		driver.get(TestBase.getBaseURL());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		return driver;
	}

	public static String Title() {
		return driver.getTitle();
	}

	public static void Close() {
		driver.close();
	}

	public static WebDriver getWebDriver() {
		return driver;
	}

	@SuppressWarnings("unused")
	private static boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}
}
