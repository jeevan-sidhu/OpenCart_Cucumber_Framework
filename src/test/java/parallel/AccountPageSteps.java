package parallel;

import java.util.Properties;

import org.junit.Assert;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPageSteps {
	
	private AccountsPage accPage;
	private Properties prop;
	private Hooks hooks;
	
	public AccountPageSteps(Hooks hooks) {
		this.hooks = hooks;
		prop = hooks.getProperties();
	}
	
	@Given("user is on the Account page")
	public void user_is_on_the_account_page() {
		accPage = hooks.getLoginPage().doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@When("user checks the account page title")
	public void user_checks_the_account_page_title() {
		String actualTitle = accPage.getAccountsPageTitle();
	    Assert.assertEquals(AppConstants.ACCOUNTS_PAGE_TITLE, actualTitle);
	}

	@Then("the account page title should be {string}")
	public void the_account_page_title_should_be(String expectedTitle) {
		Assert.assertEquals(expectedTitle, accPage.getAccountsPageTitle());
	}


}
