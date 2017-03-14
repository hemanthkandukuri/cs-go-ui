package com.hemanth.cognitive.ibibo.ui;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hemanth.cognitive.ibibo.ui.framework.BrowserFactory;
import com.hemanth.cognitive.ibibo.ui.framework.Constants;
import com.hemanth.cognitive.ibibo.ui.framework.Helpers;
import com.hemanth.cognitive.ibibo.ui.framework.PageBase;
import com.hemanth.cognitive.ibibo.ui.framework.TestBase;
import com.hemanth.cognitive.ibibo.ui.pagefactory.HomePage;
import com.hemanth.cognitive.ibibo.ui.pagefactory.LoginPage;

public class AlignmentAndFontTests extends TestBase {

	HomePage homePage = null;
	LoginPage loginPage = null;

	@BeforeClass
	public void init() {
		homePage = PageBase.HomePage();
		loginPage = PageBase.LoginPage();
		Helpers.JavaScriptClick(homePage.getLogoImage());
	}

	@AfterClass
	public void teardown() {
		Helpers.JavaScriptClick(homePage.getLogoImage());
	}

	@Test(priority = 3, groups = { "align-font-family-tests" })
	public void CheckFlightsButton() {
		Assert.assertEquals(Helpers.FontSize(homePage.getFlightsButton()), Constants.FlightsHeaderItems_FontSize);
		Assert.assertEquals(Helpers.FontFamily(homePage.getFlightsButton()), Constants.FlightsHeaderItems_FontFamily);
		Assert.assertEquals(Helpers.Alignment(homePage.getFlightsButton()), Constants.FlightsHeaderItems_Alignment);
	}
	
	@Test(priority = 3, groups = { "align-font-family-tests" })
	public void CheckHotelsButton() {
		Assert.assertEquals(Helpers.FontSize(homePage.getHotelsButton()), Constants.HotelsHeaderItems_FontSize);
		Assert.assertEquals(Helpers.FontFamily(homePage.getHotelsButton()), Constants.HotelsHeaderItems_FontFamily);
		Assert.assertEquals(Helpers.Alignment(homePage.getHotelsButton()), Constants.HotelsHeaderItems_Alignment);
	}
	
	@Test(priority = 3, groups = { "align-font-family-tests" })
	public void CheckBusButton() {
		Assert.assertEquals(Helpers.FontSize(homePage.getBusButton()), Constants.BusHeaderItems_FontSize);
		Assert.assertEquals(Helpers.FontFamily(homePage.getBusButton()), Constants.BusHeaderItems_FontFamily);
		Assert.assertEquals(Helpers.Alignment(homePage.getBusButton()), Constants.BusHeaderItems_Alignment);
	}
	
	@Test(priority = 3, groups = { "align-font-family-tests" })
	public void CheckSignInButton() {
		Assert.assertEquals(Helpers.FontSize(homePage.getSignInButton()), Constants.SignInHeaderItems_FontSize);
		Assert.assertEquals(Helpers.FontFamily(homePage.getSignInButton()), Constants.SignInHeaderItems_FontFamily);
		Assert.assertEquals(Helpers.Alignment(homePage.getSignInButton()), Constants.SignInHeaderItems_Alignment);
	}
}
