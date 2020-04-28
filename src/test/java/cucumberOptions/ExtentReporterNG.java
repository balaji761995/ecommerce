package cucumberOptions;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import base.BaseUtil;

 
public class ExtentReporterNG extends BaseUtil  {
	
	public static ExtentHtmlReporter configReport;

	public static com.aventstack.extentreports.ExtentTest test;
	public static ExtentReports extentReporter()
	{
		
		String reportPath = System.getProperty("user.dir")+"//reports//TestReport.html";
		configReport = new ExtentHtmlReporter(reportPath);
		configReport.config().setDocumentTitle("Ecommerce Test Report");
		configReport.config().setReportName("Ecommerce Webpage Test Report");
		configReport.config().setTheme(Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(configReport);
		extentReport.setSystemInfo("OS", "Windows 10");
		extentReport.setSystemInfo("Browser", "Chrome");
		return extentReport;
		
	}
	
	public static String takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"//reports//screenshot.png";
		File dest = new File(destFile);
		FileUtils.copyFile(srcFile, dest);
		return destFile;
		
	}
	
}
