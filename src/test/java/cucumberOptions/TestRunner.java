package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/feature/selectDresses.feature", glue="stepDefinitions",strict = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
