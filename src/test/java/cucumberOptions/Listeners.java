package cucumberOptions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import static base.BaseUtil.feature;
import static base.BaseUtil.testScenario;

import java.io.IOException;

import static base.BaseUtil.driver;

public class Listeners implements ITestListener {
	
	
	public String testName;
	public ExtentReports report;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		testScenario.log(Status.PASS, MarkupHelper.createLabel(Scenario.getGherkinName(),ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		testScenario.fail("Test Failed");
		try {
			testScenario.addScreenCaptureFromPath(ExtentReporterNG.takeScreenshot(driver),"Test Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
          
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		report = ExtentReporterNG.extentReporter();
		feature = report.createTest(Feature.class,"login test");
		System.out.println("Test Starts");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
