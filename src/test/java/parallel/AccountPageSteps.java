package parallel;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.ResultsPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPageSteps {

	private Properties prop;
	private Hooks hooks;
	private AccountsPage accPage;
	private LoginPage loginPage;
	private ResultsPage resultsPage;
	private ProductInfoPage productInfoPage;
	private List<String> actualHeaders;

	public AccountPageSteps(Hooks hooks) {
		this.hooks = hooks;
		prop = hooks.getProperties();
		loginPage = hooks.getLoginPage();
	}

	@Given("user is on the Account page")
	public void user_is_on_the_account_page() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
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

	@When("the user checks the page headers")
	public void the_user_checks_the_page_headers() {
		actualHeaders = accPage.getAccPageHeaders();
	}

	@Then("the page headers should be:")
	public void the_page_headers_should_be(DataTable expectedHeaders) {
		Assert.assertEquals(expectedHeaders.asList(), actualHeaders);
	}

	@When("the user searches for {string}")
	public void the_user_searches_for(String searchKey) {
		resultsPage = accPage.doSearch(searchKey);
	}

	@Then("the result count should be {int}")
	public void the_result_count_should_be(int expectedCount) {
		int actualCount = resultsPage.getSearchResultsCount();
		Assert.assertEquals(expectedCount, actualCount);
		;
	}

	@When("user selects the product {string}")
	public void user_selects_the_product(String productName) {
		productInfoPage = resultsPage.selectProduct(productName);
	}

	@Then("the slected product should be {string}")
	public void the_slected_product_should_be(String actualProductName) {
		String expectedProductName = productInfoPage.getProductHeader();
		Assert.assertEquals(expectedProductName, actualProductName);
	}

	@Then("the product information should be:")
	public void the_product_information_should_be(DataTable productData) {
		Map<String, String> actualProductMap = productInfoPage.getProductData();
		Map<String, String> expectedProductMap = productData.asMap();
		Assert.assertEquals(expectedProductMap, actualProductMap);
	}

}
