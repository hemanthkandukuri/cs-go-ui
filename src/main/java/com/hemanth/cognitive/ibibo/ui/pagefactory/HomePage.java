package com.hemanth.cognitive.ibibo.ui.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	@FindBy(how = How.XPATH, using = "//a[@class='hdrLogo']/img")
	private static WebElement LogoImage;

	@FindBy(how = How.XPATH, using = "//a[@href='/flights/']")
	private static WebElement FlightsButton;

	@FindBy(how = How.XPATH, using = "//a[@href='/hotels/']")
	private static WebElement HotelsButton;

	@FindBy(how = How.XPATH, using = "//a[@href='/bus/']")
	private static WebElement BusButton;

	@FindBy(how = How.XPATH, using = "//li[@class='hdrMoreLink']")
	private static WebElement MoreButtons;

	@FindBy(how = How.XPATH, using = "//a[@href='/trains/']")
	private static WebElement TrainButton;

	@FindBy(how = How.XPATH, using = "//span[@id='hdr_user_signin']/span/a")
	private static WebElement SignInButton;

	public  WebElement getLogoImage() {
		return LogoImage;
	}

	public  WebElement getFlightsButton() {
		return FlightsButton;
	}

	public  WebElement getHotelsButton() {
		return HotelsButton;
	}

	public  WebElement getBusButton() {
		return BusButton;
	}

	public  WebElement getMoreButtons() {
		return MoreButtons;
	}

	public  WebElement getTrainButton() {
		return TrainButton;
	}

	public  WebElement getSignInButton() {
		return SignInButton;
	}
}
