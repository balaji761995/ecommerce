package resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentBDDReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class DriverUtility{
	
	public WebDriver driver;
	public String browser;
	public static Properties prop;
	public FileInputStream file;
	public ChromeOptions chromeOpt;
	public ExtentReports extent;
	public static final Logger logger = LogManager.getLogger(DriverUtility.class.getName());
	public String filePath = System.getProperty("user.dir");
	
	public Properties property() throws IOException
	{
		
		file = new FileInputStream(filePath+"//src//main//java//resources//staticData.properties");
		prop = new Properties();
		prop.load(file);
		return prop;
	}
	
	
	public WebDriver initializeDriver() throws IOException
	{
		
		//browser = prop.getProperty("browser");
		browser = "chrome";
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", filePath+"//src//main//java//resources//chromedriver.exe");
			chromeOpt = new ChromeOptions();
			chromeOpt.addArguments("headless");
			if(browser.contains("headless"))
			{
				driver = new ChromeDriver(chromeOpt);
				logger.info("Chrome Driver Head Less Mode");
			}
			driver = new ChromeDriver();
			logger.info("Chrome Driver Initialized successfully");
					
		}
		else if(browser.contains("internet explorer"))
		{
			System.setProperty("webdriver.ie.driver", filePath+"//src//main//java//resources//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logger.info("Internet Explorer Driver Initialized Successfully");
		}
		driver.manage().window().maximize();
		logger.info("Browser Maximized");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
		
	}

	public ExtentReports extentReporter()
	{
		String reportPath = System.getProperty("user.dir")+"//reports//extentReport.html";
		ExtentHtmlReporter configExtent = new ExtentHtmlReporter(reportPath);
		configExtent.config().setDocumentTitle("Ecommerce Test Report");
		configExtent.config().setReportName("Ecommerce Cucuumber Test Report");
		extent = new ExtentReports();
		extent.attachReporter(configExtent);
		return extent;
		
	}

}
