package pages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonMethods;

/**
 * Common elements and Methods that use WebElements used across this project will be stored here
 */
public class BasePage
{
    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;

    /* **************** 
     *  CONSTRUCTOR 
     ****************** */

    /**
     * Set up initElements to enable usage of page object model
     * <p>
     * @param driver The driver to set within a page
     */
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait = new WebDriverWait(driver, 30);
    }

    /* **************** 
     *  PUBLIC METHODS 
     ****************** */

    /**
     * Get the date in a certain format
     * <p>
     * @return formattedDate Returns the date in a certain format
     */
    public String getFormattedDate()
    {
        String day = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd"));
        String englishDay = "";
        if (day.substring(day.length() - 1).contentEquals("1"))
        {
            englishDay = day.concat("st");
        }
        else if (day.substring(day.length() - 1).contentEquals("2"))
        {
            englishDay = day.concat("nd");
        }
        else if (day.substring(day.length() - 1).contentEquals("3"))
        {
            englishDay = day.concat("rd");
        }
        else
        {
            englishDay = day.concat("th");
        }
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMM "));
        String year = LocalDateTime.now().format(DateTimeFormatter.ofPattern(" yyyy"));
        return date.concat(englishDay).concat(year);
    }

    /**
     * Get the weather wrapper element
     * <p>
     * @return weatherWrapper Returns the weather wrapper element
     */
    public WebElement getWeatherWrapper()
    {
        return driver.findElement(By.cssSelector("#weather-wrapper"));
    }
    
    /**
     * Get the secondary navigation element
     * <p>
     * @return secondaryNav Returns the secondary navigation element
     */
    public WebElement getSecondaryNavigation()
    {
        return driver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div[2]"));
    }

    /**
     * Wait for the logo to appear in the header
     */
    public void waitForLogo()
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".masthead #logo"))));
    }

    /**
     * Accept cookies
     */
    public void acceptCookies()
    {
        CommonMethods.clickElement(driver, driver.findElement(By.cssSelector(".primary_2xk2l")));
    }

    /**
     * Navigate to a menu
     * <p>
     * @param menuName The menu to navigate to
     */
    public void navigateToMenu(String menuName)
    {
        WebElement menu = driver.findElement(By.cssSelector("ul[data-track-module='nav-primary^primary']")).findElement(By.xpath("//a[text()='" + menuName + "']"));
        menu.click();
        if (CommonMethods.isStale(menu) == true)
        {
            wait.until(ExpectedConditions.attributeContains(driver.findElement(By.cssSelector("ul[data-track-module='nav-primary^primary']")).findElement(By.xpath("//a[text()='" + menuName + "']")).findElement(By.xpath("..")), "class", "selected"));
        }
        else
        {
            wait.until(ExpectedConditions.attributeContains(menu.findElement(By.xpath("..")), "class", "selected"));
        }
    }

    /**
     * Wait for the secondary navigation to open
     */
    public void waitForSecondaryOpen()
    {
        wait.until(ExpectedConditions.visibilityOf(getSecondaryNavigation()));
    }
    
    /**
     * Navigate to the sub-menu
     * <p>
     * @param menuName The menu to navigate to
     */
    public void navigateToSubMenu(String menuName)
    {
        getSecondaryNavigation().findElement(By.xpath("//a[text()='" + menuName + "']")).click();
    }   
    
    /**
     * Wait for 2 windows to be open
     */
    public void waitForTwoWindows()
    {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }
}