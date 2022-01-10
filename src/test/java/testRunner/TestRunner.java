package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = ".\\src\\FeatureFiles\\Login.feature", glue = { "stepDefinitions" },

		monochrome = true,
		strict = true,

		// tags= {"@sanity"},
		tags = "@regression" , plugin = { "pretty", "html:test-output" }

)

public class TestRunner extends AbstractTestNGCucumberTests {

}
