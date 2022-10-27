package stepDefs;

import pages.HomePage;
import utilities.ScenarioContext;
import utilities.TestContext;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Steps relating to the home page are found here.
 */
public class HomeStepDef
{
    private HomePage homePage;
    private ScenarioContext scenarioContext;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Initialise page classes into objects
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise pages/driver
     */
    public HomeStepDef(TestContext testContext)
    {
        homePage = testContext.getPageObjectManager().getHomePage();
        scenarioContext = testContext.getScenarioContext();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Navigate to the site
     * <p>
     * @param environment The environment to navigate to
     */
    @Given("^I have navigated to the Daily Mail (.*) site$")
    public void launchUrl(String environment)
    {
        homePage.navigateToSite(environment);
        homePage.acceptCookies();
        homePage.waitForLogo();
    }

    /**
     * Navigate to a menu
     * <p>
     * @param menuName The menu to navigate to
     */
    @When("^I navigate to the (.*) menu$")
    public void navigateToMenu(String menuName)
    {
        homePage.navigateToMenu(menuName);
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.MENU_NAME, menuName);
    }
    
    /**
     * Navigate to the sub-menu
     * <p>
     * @param menuName The menu to navigate to
     */
    @When("^I click into the (.*) sub-category$")
    public void navigateToSubMenu(String menuName)
    {
        homePage.navigateToSubMenu(menuName);
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.MENU_NAME, menuName);
        homePage.waitForSubTopic(menuName.toLowerCase());
    }   

    /**
     * Click first article
     */
    @When("^I click the first article$")
    public void clickFirstArticle()
    {
        homePage.clickFirstArticle();
    }

    /**
     * Check the correct date is shown
     */
    @Then("^the date will be correct$")
    public void checkDate()
    {
        Assert.assertTrue(homePage.getWeatherWrapper().getText().contains(homePage.getFormattedDate()));
    }

    /**
     * Check the secondary navigation is open
     */
    @Then("^the secondary navigation will open$")
    public void checkSecondaryNavigationOpen()
    {
        homePage.waitForSecondaryOpen();
        Assert.assertTrue(homePage.getSecondaryNavigation().getAttribute("class").contains(scenarioContext.getScenarioContextAsString(ScenarioContext.Context.GENERAL.MENU_NAME).toLowerCase()));
    }
}