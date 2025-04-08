package parallel;

import org.junit.Assert;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private Hooks hooks;
	private LoginPage loginPage;
	private AccountsPage accPage;
	
	public LoginSteps(Hooks hooks) {
		this.hooks = hooks;
	}
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		loginPage = hooks.getLoginPage();
	}

	@When("user checks the login page title")
	public void user_checks_the_login_page_title() {
	    String actualTitle = loginPage.getLoginPageTitle();
	    Assert.assertEquals(AppConstants.LOGIN_PAGE_TITLE, actualTitle);
	    
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
	    Assert.assertEquals(expectedTitle, loginPage.getLoginPageTitle());
	}

	@Then("the URL should contain {string}")
	public void the_url_should_contain(String fractionUrl) {
	    String actualUrl = loginPage.getLoginPageUrl();
	    Assert.assertTrue(actualUrl.contains(fractionUrl));
	}

	@Then("the forgot password link should be displayed")
	public void the_forgot_password_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("the user logs in with username {string} and password {string}")
	public void the_user_logs_in_with_username_and_password(String username, String password) {
	    accPage = loginPage.doLogin(username, password);
	}

	@Then("the user should be redirected to the accounts page with title {string}")
	public void the_user_should_be_redirected_to_the_accounts_page_with_title(String expectedTitle) {
		Assert.assertEquals(expectedTitle, accPage.getAccountsPageTitle());
	}

}
