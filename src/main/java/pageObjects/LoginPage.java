package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submitBtn;
	

	public WebElement enterEmailId()
	{
		return emailId;
	}
	
	public WebElement enterPassword()
	{
		return password;
	}
	public WebElement clickSubmitButton()
	{
		return submitBtn;
	}
	
	
}
