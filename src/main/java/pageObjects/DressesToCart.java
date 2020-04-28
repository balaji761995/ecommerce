package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesToCart {
	
	public WebDriver driver;
	public DressesToCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//ul[contains(@class,'product_list')]")
	WebElement productList;
	
	@FindBy(css="span[title='Continue shopping']")
	WebElement continueShopping;
	
	@FindBy(css="a[title='Proceed to checkout']")
	WebElement proceedCheckout;
	
	public Actions a;
	
	
	public WebElement addDressToCart(String productName, int price)
	{
		int i,j=1;
		List<WebElement> dressesName = productList.findElements(By.cssSelector("a[class='product-name']"));
		List<WebElement> itemPrice = productList.findElements(By.cssSelector("span[class='price product-price']"));
		WebElement addToCart = null;
		String convertedPrice = Integer.toString(price);
		a = new Actions(driver);
		
		for(i=0; i<dressesName.size(); i++)
		{
			if(dressesName.get(i).getText().contains(productName) && itemPrice.get(i+j).getText().contains(convertedPrice))
			{
				
				a.moveToElement(dressesName.get(i)).build().perform();
				addToCart = productList.findElement(By.xpath("(//a/span[text()='Add to cart'])["+(i+1)+"]")); 
				break;
			}
			j++;
		}
		return addToCart;
	}
	
	public WebElement continueShopping()
	{
		return continueShopping;
	}
	
	public WebElement proceedToCheckout()
	{
		return proceedCheckout;
	}
}
