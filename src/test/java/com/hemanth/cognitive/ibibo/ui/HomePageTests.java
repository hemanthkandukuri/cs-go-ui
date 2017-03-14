package com.hemanth.cognitive.ibibo.ui;

import com.hemanth.cognitive.ibibo.ui.framework.Constants;
import com.hemanth.cognitive.ibibo.ui.framework.Helpers;
import com.hemanth.cognitive.ibibo.ui.framework.PageBase;
import com.hemanth.cognitive.ibibo.ui.framework.TestBase;
import com.hemanth.cognitive.ibibo.ui.pagefactory.HomePage;
import com.hemanth.cognitive.ibibo.ui.pagefactory.PopupFrame;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

	HomePage homepage;
	PopupFrame popupFrame;

	@BeforeClass
	public void init() {
		popupFrame = PageBase.PopupFrame();
		if (popupFrame.promoFrameExists())
			popupFrame.promoFrameClose();
		homepage = PageBase.HomePage();
		Helpers.JavaScriptClick(homepage.getLogoImage());
	}

	@AfterClass
	public void teardown() {
		Helpers.JavaScriptClick(homepage.getLogoImage());
	}

	@Test(description = "Check if the correct URL is loaded in Browser", 
			priority = 1,
			groups = {"Home-Page-Tests"})
	public void CheckUrlLoaded() {
		Assert.assertTrue(driver.getCurrentUrl().equals(TestBase.getBaseURL()));
	}

	@Test(description = "Checking, if clicked on site's logo home page loads",
			priority = 2,
			dependsOnMethods = {"CheckUrlLoaded"},
			groups = {"Home-Page-Tests"})
	public void ClickOnLogo() {
		homepage.getLogoImage().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(TestBase.getBaseURL()));
	}

	@Test(description = "Check Flights button is working",
			priority = 2,
			dependsOnMethods = {"CheckUrlLoaded"},
			groups = {"Home-Page-Tests"})
	public void CheckFlightsLabel() {
		Assert.assertTrue(homepage.getFlightsButton().getText().equals(Constants.FlightsLabel));
		homepage.getFlightsButton().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(Constants.FlightsURL));
	}

	@Test(description = "Check Hotels button is working",
			priority = 2,
			dependsOnMethods = {"CheckUrlLoaded"},
			groups = {"Home-Page-Tests"})
	public void CheckHotelsLabel() {
		Assert.assertTrue(homepage.getHotelsButton().getText().equals(Constants.HotelsLabel));
		homepage.getHotelsButton().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(Constants.HotelsURL));
	}

	@Test(description = "Check Bus button is working",
			priority = 2,
			dependsOnMethods = {"CheckUrlLoaded"},
			groups = {"Home-Page-Tests"})
	public void CheckBusLabel() {
		Assert.assertTrue(homepage.getBusButton().getText().equals(Constants.BusLabel));
		homepage.getBusButton().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(Constants.BusURL));
	}

	@Test(description = "Hover on 'more +' to get the menu and Check if Train Schedules button is present.",
			priority = 2,
			dependsOnMethods = {"CheckUrlLoaded"},
			groups = {"Home-Page-Tests"})
	public void CheckMoreButtonsMenu() {
		Assert.assertFalse(homepage.getTrainButton().isDisplayed());
		Helpers.HoverOnElement(homepage.getMoreButtons());
		Assert.assertTrue(homepage.getTrainButton().isDisplayed());
	}

	@Test(description = "Check Train Schedules Button is Working.", 
			dependsOnMethods = { "CheckMoreButtonsMenu", "CheckUrlLoaded" },
			priority = 2,
			groups = {"Home-Page-Tests"})
	public void CheckTrainButtonsMenu() {
		Helpers.HoverOnElement(homepage.getMoreButtons());
		homepage.getTrainButton().click();
		Assert.assertTrue(driver.getCurrentUrl().equals(Constants.TrainURL));
	}

}
