package com.hemanth.cognitive.ibibo.ui.framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

	static Actions actions = new Actions(BrowserFactory.getWebDriver());

	public static String Color(WebElement element) {
		return element.getCssValue("color");
	}

	public static String BackgroundColor(WebElement element) {
		return element.getCssValue("background-color");
	}

	public static String Alignment(WebElement element) {
		return element.getCssValue("text-align");
	}

	public static String FontFamily(WebElement element) {
		return element.getCssValue("font-family");
	}

	public static String FontSize(WebElement element) {
		return element.getCssValue("font-size");
	}

	public static void HoverOnElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public static void ClickAndWait(WebElement element) {
		actions.moveToElement(element).build().perform();
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getWebDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public static void JavaScriptClick(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.getWebDriver();
		executor.executeScript("arguments[0].click();", element);
	}

}
