package parallel;

import org.junit.Assert;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	LoginPage loginPage;
	
	public LoginSteps(Hooks hooks) {
		loginPage = hooks.getLoginPage();
	}
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		//User is already on the Login Page
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

}
