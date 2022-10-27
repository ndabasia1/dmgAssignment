package stepDefs;

import pages.ArticlePage;
import utilities.ScenarioContext;
import utilities.TestContext;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Steps relating to the cart page are found here.
 */
public class ArticleStepDef
{
    private ArticlePage articlePage;
    private WebDriver driver;
    private String winHandleBefore;
    private ScenarioContext scenarioContext;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Initialise page classes into objects
     * <p>
     * @param testContext Allows usage of TestContext methods to initialise pages/driver
     */
    public ArticleStepDef(TestContext testContext)
    {
        articlePage = testContext.getPageObjectManager().getArticlePage();
        driver = testContext.getDriverUtilities().getDriver();
        scenarioContext = testContext.getScenarioContext();
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Click into gallery
     */
    @When("^I go to the article's gallery$")
    public void clickGallery()
    {
        articlePage.clickGallery();
    }

    /**
     * Click next in the gallery
     */
    @When("^I click next in the gallery$")
    public void clickNext()
    {
        articlePage.clickNext();
    }

    /**
     * Close gallery view
     */
    @When("^I close the gallery view$")
    public void closeGallery()
    {
        articlePage.closeGallery();
    }

    /**
     * Hover over gallery
     */
    @When("^I hover over the gallery$")
    public void hoverOverGallery()
    {
        articlePage.hoverOverGallery();
    }

    /**
     * Click a social icon
     * <p>
     * @param socialName The social to click
     */
    @When("^I click (.*) on the gallery$")
    public void clickSocial(String socialName)
    {
        winHandleBefore = driver.getWindowHandle();
        articlePage.clickSocial();
    }
    
    /**
     * Go to the team
     * <p>
     * @param teamName The name of the team to get to
     */
    @When("^I navigate to (.*) in the league table$")
    public void scrolToTeam(String teamName)
    {
        articlePage.scrollToLeagueTable();
        scenarioContext.setContext(ScenarioContext.Context.GENERAL.TEAM_NAME, teamName);
    }
    
    /**
     * Click full-screen on an embedded video
     */
    @When("^I click the fullscreen icon on the embedded video$")
    public void clickScreenSizeVideo()
    {
//        scenarioContext.setContext(ScenarioContext.Context.GENERAL.VIDEO_SIZE, articlePage.getVideoElement().getAttribute("style"));
//        articlePage.clickScreenSizeVideo();
    }

    /**
     * Check the previous and next icon is present
     */
    @Then("^the previous and next icon will be present$")
    public void checkPreviousNextIcon()
    {
        try
        {
            Assert.assertTrue(articlePage.getPreviousIcon().isDisplayed());
            Assert.assertTrue(!articlePage.getPreviousIcon().isEnabled());
            Assert.assertTrue(articlePage.getNextIcon().isDisplayed());
        }
        catch (NoSuchElementException e)
        {
            fail();
        }
    }

    /**
     * Check the counter updates
     * <p>
     * @param counter The counter to check for
     */
    @Then("^the counter changes to (.*)$")
    public void checkCounter(String counter)
    {
        Assert.assertTrue(articlePage.getCounterElement().getText().contains(counter));
    }

    /**
     * Check the correct dialog opens
     * <p>
     * @param dialogName The name of the dialog to check for
     */
    @Then("^the (.*) dialog will open$")
    public void checkDialog(String dialogName)
    {
        articlePage.waitForTwoWindows();
        for (String winHandle : driver.getWindowHandles())
        {
            if (!winHandleBefore.contentEquals(winHandle))
            {
                driver.switchTo().window(winHandle);
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains(dialogName));
        driver.close();
        driver.switchTo().window(winHandleBefore);
    }
    
    /**
     * Check the video size has changed
     */
    @Then("^the video will change size$")
    public void checkVideoSize()
    {
//        articlePage.waitForVideoSizeToChange(scenarioContext.getScenarioContextAsString(ScenarioContext.Context.GENERAL.VIDEO_SIZE));
    }
    
    /**
     * Get the team's points and position
     */
    @Then("^the points and position will be displayed$")
    public void checkPointsPosition()
    {
        articlePage.getPointPosition(scenarioContext.getScenarioContextAsString(ScenarioContext.Context.GENERAL.TEAM_NAME));
    }
}