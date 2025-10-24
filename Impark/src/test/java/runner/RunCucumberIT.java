package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(
		features={"src/test/resources/Features"},
		glue={"StepDefinition","appsHooks"},
		plugin = {
			"pretty","html:target/cucumber-report.html",
			"json:target/JSONReports/jsonReport.json",
			"junit:target/junitReports/junitReport.xml",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		 		 },
		monochrome= true,
		dryRun= false,
		tags="@Search"
)
public class RunCucumberIT
{
	
	
}