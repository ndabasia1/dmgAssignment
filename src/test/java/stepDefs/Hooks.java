package stepDefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utilities.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * Sets up parameters to be run before and after a test
 */
public class Hooks
{
    private TestContext testContext;
    public static Scenario scenario;

    /**
     * Initialise test context so that the driver is created
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise the driver
     */
    public Hooks(TestContext context)
    {
        testContext = context;
    }

    /**
     * Prepare the steps to be run before each test
     */
    @Before
    public void BeforeSteps(Scenario scenario)
    {
        Hooks.scenario = scenario;
    }

    /**
     * Checks to see if a scenario fails or not, if it does, it takes a screenshot. Driver is then closed.
     * <p>
     * @param scenario The scenario to check whether it passes or not
     */
    @After
    public void close(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            scenario.embed(((TakesScreenshot) testContext.getDriverUtilities().getDriver()).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        testContext.getDriverUtilities().cleanUp();
    }
}