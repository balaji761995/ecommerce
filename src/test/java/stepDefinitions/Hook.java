package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.*;
import cucumberOptions.ExtentReporterNG;
import resources.DriverUtility;

public class Hook extends BaseUtil {
	
	public BaseUtil base;
	public Hook(BaseUtil base)
	{
		this.base = base;
	}
	
	DriverUtility browser = new DriverUtility();
	public Properties data;
	
	ExtentReporterNG report = new ExtentReporterNG();
	@Before
	public void startBrowser(Scenario scenario) throws IOException {
		
		base.testScenario = base.feature.createNode(scenario.getName());		
		if(base.driver==null)
		{
			base.driver = browser.initializeDriver();
		}
	
	}
	

	
	@Before
	public void staticData() throws IOException
	{
		base.prop = browser.property();
	}
	
	@After
	public void closeBrowser()
	{
		base.driver.close();
		base.driver = null;
		base.prop = null;
	} 
	

}
