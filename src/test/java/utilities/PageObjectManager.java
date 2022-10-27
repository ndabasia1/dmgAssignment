package utilities;

import org.openqa.selenium.WebDriver;

import pages.ArticlePage;
import pages.HomePage;

/**
 * Allows all the page objects to be declared here
 */
public class PageObjectManager
{
    private WebDriver driver;
    private HomePage homePage;
    private ArticlePage articlePage;

    /**
     * Allows the driver to be set for each page
     * <p>
     * @param driver The driver to set within a page
     */
    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * Allow usage of Home Page's methods
     */
    public HomePage getHomePage()
    {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }
    
    /**
     * Allow usage of Cart Page's methods
     */
    public ArticlePage getArticlePage()
    {
        return (articlePage == null) ? articlePage = new ArticlePage(driver) : articlePage;
    }
}