package utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Sets up the driver to run tests
 */
public class DriverUtilities
{
    private WebDriver driver;

    /**
    * Calls the driver, if none is found then it is created
    * <p>
    * @return driver Returns a driver
    */
    public WebDriver getDriver()
    {
        if (driver == null)
        {
            CreateDriver();
        }
        return driver;
    }

    /**
     * Creates an instance of a driver
     */
    private void CreateDriver()
    {
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "externalFiles");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Arguments required if running in headless mode or through docker
        options.addArguments("headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=2560,1440");
        this.driver = new ChromeDriver(options);
    }

    /**
     * Close the driver
     */
    public void cleanUp()
    {
        driver.close();
        driver.quit();
    }
}