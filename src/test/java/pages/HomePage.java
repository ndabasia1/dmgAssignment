package pages;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import data.Constants.Messages;
import data.Constants.DailyMail;
import data.Constants.Url;

/**
 * This page contains methods and WebElements relating to the Home Page
 */
public class HomePage extends BasePage
{
    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Use the constructor set within Base Page
     * <p>
     * @param driver The driver to set within the page
     */
    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Navigate to the correct URL
     * <p>
     * @param environment Environment to navigate to
     */
    public void navigateToSite(String environment)
    {
        switch (environment)
        {
            case DailyMail.MAIN:
                driver.get(Url.DM);
                break;
            default:
                fail(Messages.NO_ENVIRONMENT);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }    
    
    /**
     * Wait for the secondary topic to open
     * <p>
     * @param subTopic The subtopic to wait to appear
     */
    public void waitForSubTopic(String subTopic)
    {
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector(".article-tri-headline")), "data-track-module", subTopic));
    }
    
    /**
     * Click first article
     */
    public void clickFirstArticle()
    {
        driver.findElement(By.cssSelector(".article-tri-headline h2")).click();
    }
}