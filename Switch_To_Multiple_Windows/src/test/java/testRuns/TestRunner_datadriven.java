package testRuns;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)



@CucumberOptions(
		

		features="src/test/resources/features/dataDrivenTesting/datadriven_feature.feature",
		

		glue = {"stepDefinations","hooks"},

		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun = false,
				monochrome = true
				)


public class TestRunner_datadriven {

}
