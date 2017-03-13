package com.hemanth.cognitive.ibibo.ui.framework;

import org.openqa.selenium.support.PageFactory;

import com.hemanth.cognitive.ibibo.ui.pagefactory.HomePage;
import com.hemanth.cognitive.ibibo.ui.pagefactory.LoginPage;
import com.hemanth.cognitive.ibibo.ui.pagefactory.PopupFrame;

/**
 * @author hkandukuri
 *
 */
public final class PageBase {
	private static <T> T GetPage(Class<T> pageType) {
		T page;
		try {
			page = pageType.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		}

		catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		PageFactory.initElements(BrowserFactory.getWebDriver(), page);
		return page;
	}

	public static HomePage HomePage() {
		return GetPage(HomePage.class);
	}
	public static LoginPage LoginPage() {
		return GetPage(LoginPage.class);
	}
	public static PopupFrame PopupFrame() {
		return GetPage(PopupFrame.class);
	}
}

