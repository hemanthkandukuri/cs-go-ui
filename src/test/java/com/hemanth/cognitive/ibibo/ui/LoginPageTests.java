package com.hemanth.cognitive.ibibo.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hemanth.cognitive.ibibo.ui.framework.Constants;
import com.hemanth.cognitive.ibibo.ui.framework.Helpers;
import com.hemanth.cognitive.ibibo.ui.framework.PageBase;
import com.hemanth.cognitive.ibibo.ui.framework.TestBase;
import com.hemanth.cognitive.ibibo.ui.pagefactory.HomePage;
import com.hemanth.cognitive.ibibo.ui.pagefactory.LoginPage;

public class LoginPageTests extends TestBase {

	WebDriverWait wait;

	HomePage homePage = null;
	LoginPage loginPage = null;
	
	
	@BeforeClass
	public void init() {
		homePage = PageBase.HomePage();
		loginPage = PageBase.LoginPage();
		wait = new WebDriverWait(driver, 15);
		homePage.getBusButton().click();
	}

	@AfterClass
	public void TearDownSignIn() {
		driver.switchTo().defaultContent();
		Helpers.JavaScriptClick(homePage.getLogoImage());
	}
	
	@Test(description = "Check Sign In button is displayed",
			priority = 1,
			groups = {"Home-Page-Tests", "Login-Frame-Tests"})
	public void CheckSignInButtonIsDisplayedOnHomePage() {
		Assert.assertTrue(homePage.getSignInButton().isDisplayed());
	}

	@Test(
			description = "Clicking on Sign In Button Opens the Sign In Form/Frame", 
			priority = 1,
			groups = {"Login-Frame-Tests"}, 
			dependsOnMethods = {"CheckSignInButtonIsDisplayedOnHomePage"}
			)
	public void CheckSignInFormLoaded() throws InterruptedException {
		homePage.getSignInButton().click();
		driver.switchTo().frame(loginPage.getLoginForm());
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
	}

	@Test(
			description = "Check if the UserName Label is Present", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"}
			)
	public void CheckUserNameLabel() {
		Assert.assertTrue(loginPage.getUserName_Label().getText().equals(Constants.LoginFormUserNameLabel));
	}

	@Test(
			description = "Check if the Password Label is Present", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"}
			)
	public void CheckPasswordLabel() {
		Assert.assertTrue(loginPage.getPassword_Label().getText().equals(Constants.LoginFormPasswordLabel));
	}

	@Test(
			description = "Check if the Forgot Password Label is Present", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"}
			)
	public void CheckForgotPasswordLabel() {
		Assert.assertTrue(loginPage.getForgot_Password_Link().getText().equals(Constants.LoginFormForgotPasswordLabel));
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(loginPage.getForgot_Password_Link()))
				.equals(loginPage.getForgot_Password_Link()));
	}

	@Test(
			description = "Check if the Sign In Label is Present", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"}
			)
	public void CheckSignInLabel() {
		Assert.assertTrue(loginPage.getSignIn().getAttribute("value").equals(Constants.LoginFormSignInLabel));
		Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(loginPage.getSignIn()))
				.equals(loginPage.getSignIn()));
		loginPage.ClickSignInButton();
	}

	/* Test Cases for Sign In feature */
	@Test(
			description = "Blank User Name and Password", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"}
			)
	public void ClickSignInWithBlankUserNameAndPassword() {
		loginPage.getUserName_Input().clear();
		loginPage.getPassword_Input().clear();
		loginPage.ClickSignInButton();
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertTrue(loginPage.getError_Icon().getText().equals(Constants.LoginFormErrorIconLabel));
		Assert.assertTrue(loginPage.getError_Message().getText().equals(Constants.LoginFormUserNameErrorMessageLabel));
	}

	@Test(
			description = "Blank User Name and random string as password", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"}
			)
	public void ClickSignInWithBlankUserName() {
		loginPage.getUserName_Input().clear();
		loginPage.getPassword_Input().clear();
		loginPage.getPassword_Input().sendKeys(Constants.LoginFormDummyPassword);
		loginPage.ClickSignInButton();
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertTrue(loginPage.getError_Icon().getText().equals(Constants.LoginFormErrorIconLabel));
		Assert.assertTrue(loginPage.getError_Message().getText().equals(Constants.LoginFormUserNameErrorMessageLabel));
	}

	@Test(
			description = "Random User Name and blank string as password", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"})
	public void ClickSignInWithBlankPassword() {
		loginPage.getUserName_Input().clear();
		loginPage.getPassword_Input().clear();
		loginPage.getUserName_Input().sendKeys(Constants.LoginFormDummyUserName);
		loginPage.ClickSignInButton();
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertTrue(loginPage.getError_Icon().getText().equals(Constants.LoginFormErrorIconLabel));
		Assert.assertTrue(loginPage.getError_Message().getText().equals(Constants.LoginFormPasswordErrorMessageLabel));
	}

	@Test(
			description = "Mobile Number as User Name and blank string as password", 
			dependsOnMethods = {"CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"})
	public void ClickSignInWithBlankPasswordAndPopulatedMobileNumber() {
		loginPage.getUserName_Input().clear();
		loginPage.getPassword_Input().clear();
		loginPage.getUserName_Input().sendKeys(Constants.LoginFormDummyMobileNumber);
		loginPage.ClickSignInButton();
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertTrue(loginPage.getError_Icon().getText().equals(Constants.LoginFormErrorIconLabel));
		Assert.assertTrue(loginPage.getError_Message().getText().equals(Constants.LoginFormPasswordErrorMessageLabel));
	}

	@Test(
			description = "Incorrect Email and Password", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"})
	public void SigiInWithIncorrectEmailAndPassword() {
		loginPage.getUserName_Input().clear();
		loginPage.getPassword_Input().clear();
		loginPage.getPassword_Input().sendKeys(Constants.LoginFormDummyUserName);
		loginPage.getPassword_Input().sendKeys(Constants.LoginFormDummyPassword);
		loginPage.ClickSignInButton();
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertTrue(loginPage.getError_Icon().getText().equals(Constants.LoginFormErrorIconLabel));
	}

	@Test(
			description = "Incorrect Email and Password", 
			dependsOnMethods = { "CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"})
	public void SigiInWithIncorrectMobileAndPassword() {
		loginPage.getUserName_Input().clear();
		loginPage.getPassword_Input().clear();
		loginPage.getPassword_Input().sendKeys(Constants.LoginFormDummyMobileNumber);
		loginPage.getPassword_Input().sendKeys(Constants.LoginFormDummyPassword);
		loginPage.ClickSignInButton();
		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertTrue(loginPage.getError_Icon().getText().equals(Constants.LoginFormErrorIconLabel));
		Assert.assertFalse(
				loginPage.getError_Message().getText().equals(Constants.LoginFormInvalidLoginErrorMessageLabel));
	}

	@Test(description = "Check even if Copy & Paste Password should be Masked", 
			dependsOnMethods = {"CheckSignInFormLoaded" }, 
			priority = 2,
			groups = {"Login-Frame-Tests"})
	public void CheckCopyOfPasswordIsMasked() {
		loginPage.getPassword_Input().clear();
		loginPage.getPassword_Input().sendKeys(Constants.LoginFormDummyPassword);
		loginPage.getPassword_Input().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		loginPage.getPassword_Input().sendKeys(Keys.chord(Keys.CONTROL, "c"));
		loginPage.getUserName_Input().sendKeys(Keys.chord(Keys.CONTROL, "v"));

		Assert.assertTrue(loginPage.getLoginFormHeading().getText().equals(Constants.LoginFormHeaderLabel));
		Assert.assertFalse(Constants.LoginFormDummyPassword.equals(loginPage.getUserName_Input().getText()));
	}
	
	/* Test cases for Colors of Sign In Frame*/
	@Test(
			priority = 3,
			groups = {"Color-Test", "Login-Frame-Tests"}, 
			dependsOnMethods = {"CheckSignInFormLoaded"}
			)
	public void CheckHoverColorOfSignInButtonInIFrame() {
		Assert.assertEquals(Helpers.BackgroundColor(loginPage.getSignIn()), Constants.DarkBlueColorInRGB);
		
		Helpers.HoverOnElement(loginPage.getSignIn());
		Assert.assertEquals(Helpers.Color(loginPage.getSignIn()), Constants.ModerateColorInRGB);
	}
	
	@Test(
			priority = 3,
			groups = {"Color-Test", "Login-Frame-Tests"},
			dependsOnMethods = {"CheckSignInFormLoaded"}
			)
	public void CheckHoverColorOfForgotPasswordButtonInIFrame() { 
		Assert.assertEquals(Helpers.Color(loginPage.getForgot_Password_Link()), Constants.StrongBlueColorInRGB);
		
		Helpers.HoverOnElement(loginPage.getForgot_Password_Link());
		Assert.assertEquals(Helpers.Color(loginPage.getForgot_Password_Link()), Constants.VividOrangeColorInRGB_2);
	}
}
