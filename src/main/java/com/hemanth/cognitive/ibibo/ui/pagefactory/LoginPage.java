package com.hemanth.cognitive.ibibo.ui.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.hemanth.cognitive.ibibo.ui.framework.Helpers;

public class LoginPage {

	@FindBy(how = How.XPATH, using = "//iframe[@id='authiframe']")
	private static WebElement LoginForm;

	@FindBy(how = How.XPATH, using = "//div[@class='popIframe']/h4")
	private static WebElement LoginFormHeading;

	@FindBy(how = How.XPATH, using = "//div[@id='form_error']/div/span/b")
	private static WebElement Error_Icon;

	@FindBy(how = How.XPATH, using = "//div[@id='form_error']/div/span/span")
	private static WebElement Error_Message;

	@FindBy(how = How.XPATH, using = "//input[@id='id_username']/preceding-sibling::label")
	private static WebElement UserName_Label;

	@FindBy(how = How.XPATH, using = "//input[@id='id_username']")
	private static WebElement UserName_Input;

	@FindBy(how = How.XPATH, using = "//input[@id='id_password']/preceding-sibling::label")
	private static WebElement Password_Label;

	@FindBy(how = How.XPATH, using = "//input[@id='id_password']")
	private static WebElement Password_Input;

	@FindBy(how = How.XPATH, using = "//input[@id='id_password']/following-sibling::div/a")
	private static WebElement Forgot_Password_Link;

	@FindBy(how = How.ID, using = "signinBtn")
	private static WebElement SignIn;

	public WebElement getLoginForm() {
		return LoginForm;
	}

	public WebElement getLoginFormHeading() {
		return LoginFormHeading;
	}

	public WebElement getError_Icon() {
		return Error_Icon;
	}

	public WebElement getError_Message() {
		return Error_Message;
	}

	public WebElement getUserName_Label() {
		return UserName_Label;
	}

	public WebElement getUserName_Input() {
		return UserName_Input;
	}

	public WebElement getPassword_Label() {
		return Password_Label;
	}

	public WebElement getPassword_Input() {
		return Password_Input;
	}

	public WebElement getForgot_Password_Link() {
		return Forgot_Password_Link;
	}

	public WebElement getSignIn() {
		return SignIn;
	}
	
	public void ClickSignInButton() {
		Helpers.JavaScriptClick(SignIn);
	}
	
	public void ClickForgotPasswordButton() {
		Helpers.JavaScriptClick(Forgot_Password_Link);
	}
}
