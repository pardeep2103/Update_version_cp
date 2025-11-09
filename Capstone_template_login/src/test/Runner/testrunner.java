package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resource/Features",
    glue = "stepdef",
    tags = "@final",
    plugin = {"pretty",
    		"html:target/cucumber-reports.html",
    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    		}

)
public class testrunner extends AbstractTestNGCucumberTests {
}

//we don't need to create' test package for testng this is the use for testng