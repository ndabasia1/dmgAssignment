package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * The below settings enable the Gherkin syntax to run the selenium tests. 
 * features is the file path where the Gherkin scenarios are located 
 * glue provides the package name to where the step definition is located to run the Gherkin syntax
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefs" }, tags = { "@dmgAssignment" }, plugin = { "pretty", "html:target/cucumber-reports" }, monochrome = true)

public class TestRunner
{
}