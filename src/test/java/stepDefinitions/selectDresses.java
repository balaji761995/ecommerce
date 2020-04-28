package stepDefinitions;

import pageObjects.DressesToCart;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.GherkinKeyword;
import base.BaseUtil;
import cucumber.api.java.en.*;
import static resources.DriverUtility.logger;

public class selectDresses extends BaseUtil {

	LandingPage landPage;
	DressesToCart toCart;
	Actions act;
	WebDriver driver;
	Properties prop;

	private BaseUtil base;

	public selectDresses(BaseUtil base) {
		this.base = base;
	}

	@Given("^user login to the page successfully with valid credentials$")
	public void user_login_to_the_page_successfully_with_valid_credentials() throws Throwable {

		base.testScenario.createNode(new GherkinKeyword("Given"),
				"user login to the page successfully with valid credentials");
		driver = base.driver;
		prop = base.prop;
		driver.get(prop.getProperty("url"));
		logger.info("Navigated to the URL successfully");
		landPage = new LandingPage(driver);
		landPage.clickSignButton().click();
		logger.info("Login Page link clicked successfully");
		LoginPage loginPageObjects = new LoginPage(driver);
		loginPageObjects.enterEmailId().sendKeys(prop.getProperty("username"));
		logger.info("user name entered successfully");
		loginPageObjects.enterPassword().sendKeys(prop.getProperty("password"));
		logger.info("password entered successfully");
		loginPageObjects.clickSubmitButton().click();
		logger.info("Clicked on login button");
	}

	@When("^select all the product type with given value ([^\"]*), dress type ([^\"]*), name ([^\"]*) and price ([^\"]*)$")
	public void select_all_the_product_type_with_given_value_dress_type_name_and_price(String catagory,
			String dresstype, String productname, int price) throws Throwable {
		base.testScenario.createNode(new GherkinKeyword("When"), "select all the product type with given value");
		act = new Actions(driver);
		act.moveToElement(landPage.fashionMenuList(catagory)).build().perform();
		logger.info("Mouse pointer moved to menu list");
		landPage.selectDresses(dresstype).click();
		logger.info("clicked on given dress type");
		toCart = new DressesToCart(driver);
		toCart.addDressToCart(productname, price).click();
		logger.info("Dress selected added to cart with given product name and price");

	}

	@And("^click on add to cart and continue shoppting$")
	public void click_on_add_to_cart_and_continue_shoppting() throws Throwable {
		base.testScenario.createNode(new GherkinKeyword("And"), "click on add to cart and continue shoppting");
		toCart.continueShopping().click();
		logger.info("continue to shopping button clicked");
	}

	@Then("^catagory and dress type selected successfully$")
	public void catagory_and_dress_type_selected_successfully() throws Throwable {
		base.testScenario.createNode(new GherkinKeyword("Then"), "catagory and dress type selected successfully");
		System.out.println("selected successfully");
		Assert.assertTrue(false);
	}

}