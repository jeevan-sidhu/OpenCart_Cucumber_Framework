package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtil elUtil;

	private By searchHeader = By.cssSelector("div#content h2");
	private By results = By.cssSelector("div.product-thumb");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		elUtil = new ElementUtil(driver);
	}

	public String getSearchHeader() {
		String searchHeaderValue = elUtil.waitForElementVisible(searchHeader, AppConstants.DEFAULT_SHORT_TIME_OUT)
				.getText();
		return searchHeaderValue;
	}

	public int getSearchResultsCount() {
		int resultCount = elUtil.waitForElementsVisible(results, AppConstants.DEFAULT_SHORT_TIME_OUT).size();
		System.out.println("search result count ===> " + resultCount);
		return resultCount;
	}

	public ProductInfoPage selectProduct(String productName) {
		System.out.println("selecting product: " + productName);
		elUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}

}
