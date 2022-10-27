package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.internal.Locatable;

/**
 * Common Methods used across this project will be stored here
 */
public class CommonMethods
{
    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Move the mouse cursor to hover over the top left corner of an element
     * <p>
     * @param element Element to hover over
     * @param driver The driver to carry out the action through
     */
    public static void hoverOverElement(WebElement element, WebDriver driver)
    {
        Locatable hoverItem = (Locatable) element;
        ((HasInputDevices) driver).getMouse().mouseMove(hoverItem.getCoordinates());
    }

    /**
     * Click element. Use this method if the standard click() method does not work
     * <p>
     * @param driver The driver to carry out the action through
     * @param elementToClick Element to click
     */
    public static void clickElement(WebDriver driver, WebElement elementToClick)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementToClick);
    }

    /**
     * Scroll to element
     * <p>
     * @param driver The driver to carry out the action through
     * @param elementToScrollTo Element to scroll to
     */
    public static void scrollElementIntoView(WebDriver driver, WebElement elementToScrollTo)
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
    }
    
    /**
     * Check if an element is stale
     * <p>
     * @param element Element to check for
     * @return isStale Returns a boolean on whether an element is stale or not
     */
    public static boolean isStale(WebElement element)
    {
        try
        {
            element.isDisplayed();
            return false;
        }
        catch (StaleElementReferenceException e)
        {
            return true;
        }
    }
}