package utilities;

/**
 * Allows parameters to be declared once throughout a test cycle
 */
public class TestContext
{
    private DriverUtilities driverUtilities;
    private PageObjectManager pageObjectManager;
    private ScenarioContext scenarioContext;

    /**
     * Creates objects that will be created when Test Context is used
     */
    public TestContext()
    {
        driverUtilities = new DriverUtilities();
        pageObjectManager = new PageObjectManager(driverUtilities.getDriver());
        scenarioContext = new ScenarioContext();
    }

    /**
     * Allows the usage of DriverUtilities methods through test context
     */
    public DriverUtilities getDriverUtilities()
    {
        return driverUtilities;
    }

    /**
     * Allows the usage of page methods through the PageObjectManager
     */
    public PageObjectManager getPageObjectManager()
    {
        return pageObjectManager;
    }
    
    /**
     * Allows the usage of scenario context methods
     */
    public ScenarioContext getScenarioContext()
    {
        return scenarioContext;
    }
}