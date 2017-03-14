package com.hemanth.cognitive.ibibo.ui;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hemanth.cognitive.ibibo.ui.framework.Constants;
import com.hemanth.cognitive.ibibo.ui.framework.Helpers;
import com.hemanth.cognitive.ibibo.ui.framework.PageBase;
import com.hemanth.cognitive.ibibo.ui.framework.TestBase;
import com.hemanth.cognitive.ibibo.ui.pagefactory.HomePage;
import com.hemanth.cognitive.ibibo.ui.pagefactory.LoginPage;

public class ColorTests extends TestBase {

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

	@Test(priority = 3, groups = { "Color-Test", "Home-Page-Tests" })
	public void CheckHoverColorOfFlightsButton() {
		homePage.getHotelsButton().click();
		Assert.assertEquals(Helpers.Color(homePage.getFlightsButton()), Constants.DarkBlueColorInRGB);

		Helpers.HoverOnElement(homePage.getFlightsButton());
		Assert.assertEquals(Helpers.Color(homePage.getFlightsButton()), Constants.VividOrangeColorInRGB);
	}

	@Test(priority = 3, groups = { "Color-Test", "Home-Page-Tests" })
	public void CheckHoverColorOfHotelsButton() {
		homePage.getFlightsButton().click();
		Assert.assertEquals(Helpers.Color(homePage.getHotelsButton()), Constants.DarkBlueColorInRGB);

		Helpers.HoverOnElement(homePage.getHotelsButton());
		Assert.assertEquals(Helpers.Color(homePage.getHotelsButton()), Constants.VividOrangeColorInRGB);
	}

	@Test(priority = 3, groups = { "Color-Test", "Home-Page-Tests" })
	public void CheckHoverColorOfBusButton() {
		homePage.getFlightsButton().click();
		Assert.assertEquals(Helpers.Color(homePage.getBusButton()), Constants.DarkBlueColorInRGB);

		Helpers.HoverOnElement(homePage.getBusButton());
		Assert.assertEquals(Helpers.Color(homePage.getBusButton()), Constants.VividOrangeColorInRGB);
	}

	@Test(priority = 3, groups = { "Color-Test", "Home-Page-Tests" })
	public void CheckHoverColorOfMoreLinksButton() {
		homePage.getFlightsButton().click();
		//Assert.assertEquals(Helpers.Color(homePage.getMoreButtons()), Constants.DarkBlueColorInRGB);

		Helpers.HoverOnElement(homePage.getMoreButtons());
		Assert.assertEquals(Helpers.Color(homePage.getMoreButtons()), Constants.VividOrangeColorInRGB);
	}

	@Test(priority = 3, groups = { "Color-Test", "Home-Page-Tests" })
	public void CheckHoverColorOfTrainsButton() {
		homePage.getFlightsButton().click();
		Assert.assertEquals(Helpers.Color(homePage.getTrainButton()), Constants.DarkBlueColorInRGB);

		Helpers.HoverOnElement(homePage.getMoreButtons());
		Helpers.HoverOnElement(homePage.getTrainButton());
		Assert.assertEquals(Helpers.Color(homePage.getTrainButton()), Constants.VividOrangeColorInRGB);
	}

	@Test(priority = 3, groups = { "Color-Test", "Home-Page-Tests" })
	public void CheckHoverColorOfSignInButtonInHomePage() {
		Assert.assertEquals(Helpers.Color(homePage.getSignInButton()), Constants.StrongBlueColorInRGB);

		Helpers.HoverOnElement(homePage.getSignInButton());
		Assert.assertEquals(Helpers.Color(homePage.getSignInButton()), Constants.VividOrangeColorInRGB_2);
	}

}
