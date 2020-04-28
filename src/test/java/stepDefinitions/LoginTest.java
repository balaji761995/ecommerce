package stepDefinitions;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import base.BaseUtil;
import cucumber.api.java.en.*;


public class LoginTest extends BaseUtil {
	
	WebDriver driver;
	Properties data;
	ExtentTest scenrio;
	public BaseUtil base;
	public LoginTest(BaseUtil base)
	{
		this.base = base;
	}
	
	LandingPage landPage;

	@Given("^Navigate to the landing page and click on login link$")
	public void navigate_to_the_landing_page_and_click_on_login_link() throws Throwable {
		
		
		base.testScenario.createNode(new GherkinKeyword("Given"), "Navigate to the landing page and click on login link");
		driver = base.driver;
		data = base.prop;
		driver.get(data.getProperty("url"));
		landPage = new LandingPage(driver);
		landPage.clickSignButton().click();
	}

	@When("^Enter the user name and password, click on the Sign In button$")
	public void enter_the_user_name_and_password_click_on_the_sign_in_button() throws Throwable {
		
		base.testScenario.createNode(new GherkinKeyword("When"), "Enter the user name and password, click on the Sign In button");
		LoginPage loginPageObjects = new LoginPage(driver);
		loginPageObjects.enterEmailId().sendKeys(data.getProperty("username"));
		loginPageObjects.enterPassword().sendKeys(data.getProperty("password"));
		loginPageObjects.clickSubmitButton().click();
	}

	@Then("^After clicking Sign In, successfully navigated to the homepage$")
	public void after_clicking_sign_in_successfully_navigated_to_the_homepage() throws Throwable {
		
		base.testScenario.createNode(new GherkinKeyword("Then"), "After clicking Sign In, successfully navigated to the homepage");
		Assert.assertTrue(landPage.profileName().getText().contains(data.getProperty("profileName")));

	}

}
