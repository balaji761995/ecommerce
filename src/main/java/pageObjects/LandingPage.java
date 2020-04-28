package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	//private static final String catagory = null;

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Sign in")
	WebElement signInBtn;
	
	@FindBy(css=".account:nth-child(1)")
	WebElement userName;
	
	@FindBy(xpath="//div[contains(@id,'top_menu')]/ul")
	WebElement fashionMenus;
	
	@FindBy(xpath="//a[@title='Women']/following-sibling::ul")
	WebElement womenDresses;
	
	//By Dresses = By.xpath("//a[@title='"+catagory+"']/following-sibling::ul");
	
	public WebElement clickSignButton()
	{
		return signInBtn;
	}
	public WebElement profileName()
	{
		return userName;
	}
	public WebElement fashionMenuList(String catagory)
	{
		
		List<WebElement> fashionCatagories = fashionMenus.findElements(By.tagName("li"));
		int i;
		for(i=0; i<fashionCatagories.size(); i++)
		{
			if((fashionCatagories.get(i).getText().contains(catagory)))
			{
				break;
			}
		}
		return fashionCatagories.get(i);
	}
	public WebElement selectDresses(String dresses)
	{
		//WebElement Dresses = driver.findElement(By.xpath("//a[contains(@title,'"+catagory+"')]/following-sibling::ul"));
		int j;
		List<WebElement> dressLinks = womenDresses.findElements(By.tagName("a"));
		for(j=0; j<dressLinks.size(); j++)
		{
			if(dressLinks.get(j).getText().contains(dresses))
			{
				break;
			}
		}
		return dressLinks.get(j);
	}
	
	
}
