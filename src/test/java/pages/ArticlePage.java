package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import stepDefs.Hooks;
import utilities.CommonMethods;

/**
 * This page contains methods and WebElements relating to the cart page
 */
public class ArticlePage extends BasePage
{
    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Use the constructor set within Base Page
     * <p>
     * @param driver The driver to set within the page
     */
    public ArticlePage(WebDriver driver)
    {
        super(driver);
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Get the previous icon element
     * <p>
     * @return previousIcon Returns the previous icon element
     */
    public WebElement getPreviousIcon()
    {
        return driver.findElement(By.cssSelector("button[aria-label='Previous']"));
    }
    
    /**
     * Get the next icon element
     * <p>
     * @return nextIcon Returns the next icon element
     */
    public WebElement getNextIcon()
    {
        return driver.findElement(By.cssSelector("button[aria-label='Next']"));
    }
    
    /**
     * Get the counter element
     * <p>
     * @return counter Returns the counter element
     */
    public WebElement getCounterElement()
    {
        return driver.findElement(By.cssSelector("div[class^='counter']"));
    }
    
    /**
     * Get the gallery element
     * <p>
     * @return gallery Returns the gallery element
     */
    public WebElement getGalleryElement()
    {
        return driver.findElement(By.cssSelector("button[class^='openGalleryButton']"));
    }
    
    /**
     * Get the video element
     * <p>
     * @return video Returns the video element
     */
    public WebElement getVideoElement()
    {
        return driver.findElement(By.cssSelector(".vjs-video-container .vjs-fullscreen-control")).findElement(By.xpath("../preceding-sibling::*[4]"));
    }
    
    /**
     * Click into gallery
     */
    public void clickGallery()
    {
        WebElement galleryElement = getGalleryElement();
        CommonMethods.scrollElementIntoView(driver, galleryElement);
        CommonMethods.clickElement(driver, galleryElement);
    }
    
    /**
     * Click next in the gallery
     */
    public void clickNext()
    {
        getNextIcon().click();
    }
    
    /**
     * Close gallery view
     */
    public void closeGallery()
    {
        CommonMethods.clickElement(driver, driver.findElement(By.cssSelector("button[aria-label='Close']")));
    }
    
    /**
     * Hover over gallery
     */
    public void hoverOverGallery()
    {
        CommonMethods.hoverOverElement(driver.findElement(By.cssSelector(".image-wrap")), driver);
    }
    
    /**
     * Click a social icon
     * <p>
     * @param socialName The social to click
     */
    public void clickSocial()
    {
        driver.findElement(By.cssSelector("li[data-social-scope='facebook']")).click();
    }
    
    /**
     * Click full-screen on an embedded video
     */
    public void clickScreenSizeVideo()
    {
        WebElement videoSizeControl =  driver.findElement(By.cssSelector(".vjs-video-container .vjs-fullscreen-control"));
        CommonMethods.scrollElementIntoView(driver, videoSizeControl);
        CommonMethods.clickElement(driver, videoSizeControl);
    }
    
    /**
     * Wait for the video size to change
     * <p>
     * @param videoSize The size it should not be
     */
    public void waitForVideoSizeToChange(String videoSize)
    {
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(getVideoElement(), "style", videoSize)));
    }
    
    /**
     * Scroll to the league table
     */
    public void scrollToLeagueTable()
    {
        CommonMethods.scrollElementIntoView(driver, getTableRows().get(0));
    }
    
    /**
     * Get the team's points and position
     * <p>
     * @param teamName The name of the team to get the information of
     */
    public void getPointPosition(String teamName)
    {
        for (WebElement tableRow : getTableRows())
        {
            if (tableRow.getText().contains(teamName))
            {
                Hooks.scenario.write(teamName + "'s position is " + tableRow.findElement(By.cssSelector("td[class^='pos']")).getText());
                Hooks.scenario.write(teamName + "'s points are " + tableRow.findElement(By.cssSelector("td[class^='score-pts']")).getText());
                break;
            }
        }
    }
    
    /* **************** 
     *  PRIVATE METHODS 
     ****************** */

    /**
     * Get the Table rows for the league table
     * <p>
     * @return getTableRows Returns the table rows
     */
    private List<WebElement> getTableRows()
    {
        return driver.findElements(By.cssSelector("div[class^='competitionTable'] tbody tr"));
    }
}