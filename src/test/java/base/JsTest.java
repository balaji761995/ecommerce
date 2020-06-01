package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JsTest {
	
	
	@Test
	public void test() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//java//resources//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediff.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement signin = driver.findElement(By.className("signin"));
		js.executeScript("arguments[0].click();",signin);
		String s = js.executeScript("return document.title;").toString();
		System.out.println(s);
		WebElement logintext = driver.findElement(By.id("login1"));
		js.executeScript("arguments[0].style.border='3px solid red'", logintext);
		WebElement logo = driver.findElement(By.className("logtext"));
		String color = logo.getCssValue("backgroundColor");
		for(int i =1;i<10;i++)
		{
			js.executeScript("arguments[0].style.backgroundColor='blue'", logo);
			js.executeScript("arguments[0].style.backgroundColor='"+color+"'", logo);
		}
		js.executeScript("alert('Java Script');");
	
	}

}
