package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elUtil;
	
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By registerLink = By.linkText("Register");
	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elUtil = new ElementUtil(driver);
	}
	
	public String getLoginPageTitle() {
		String title = elUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title : " + title);
		return title;
	}
	
	public String getLoginPageUrl() {
		String url = elUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page url : " + url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return elUtil.isElementDisplayed(forgotPwdLink);
	}
	
	public AccountsPage doLogin(String userName, String pwd) {
		elUtil.doSendKeys(username, userName, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		elUtil.doSendKeys(password, pwd);
		elUtil.doClick(loginBtn);
		elUtil.waitForTitleContains(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		return new AccountsPage(driver);
	}
	
	public boolean doInvalidLogin(String userName, String pwd) {
		WebElement usernameElement = elUtil.waitForElementVisible(username, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		elUtil.doSendKeys(usernameElement, userName);
		elUtil.doSendKeys(password, pwd);
		elUtil.doClick(loginBtn);
		String errorMesg = elUtil.waitForElementVisible(loginErrorMessg, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Login error --->" + errorMesg);
		if (errorMesg.contains(AppConstants.LOGIN_ERROR_MESSAGE)) {
			return true;
		}
		return false;
	}
	
	public RegisterPage navigateToRegisterPage() {
		elUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}

}
