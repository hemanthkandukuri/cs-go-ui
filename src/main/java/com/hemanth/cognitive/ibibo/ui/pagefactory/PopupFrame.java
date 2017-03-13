/**
 * 
 */
package com.hemanth.cognitive.ibibo.ui.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.hemanth.cognitive.ibibo.ui.framework.BrowserFactory;

/**
 * @author hkandukuri
 *
 */
public class PopupFrame {

	@FindBy(how = How.XPATH, using = ".//iframe[@id='webklipper-publisher-widget-container-notification-frame']")
	private static WebElement PopUpFrame;

	@FindBy(how = How.XPATH, using = ".//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	private static WebElement PopUpFrameClose;

	public static WebElement getPopUpFrame() {
		return PopUpFrame;
	}

	public static WebElement getPopUpFrameClose() {
		return PopUpFrameClose;
	}

	public boolean promoFrameExists() {
		try {
			return getPopUpFrame().isDisplayed() | getPopUpFrame().isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void promoFrameClose() {
		BrowserFactory.getWebDriver().switchTo().frame(getPopUpFrame());
		PopUpFrameClose.click();
		BrowserFactory.getWebDriver().switchTo().defaultContent();
	}
}
