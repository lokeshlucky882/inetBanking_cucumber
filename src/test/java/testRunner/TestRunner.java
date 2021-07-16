package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
		features = ".\\src\\test\\resources\\features\\",
		glue = "stepDefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"pretty", "html:target//myReport.html"},
		tags = "@regression or @smoke or @sanity"
		)
public class TestRunner 
{

}
