package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	private DriverFactory df;
	private Properties prop;
	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setUp() {
		df = new DriverFactory();
		prop = df.loadConfigProperties();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Properties getProperties() {
		return prop;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

}
