package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class WebDriverManager {
    private WebDriver driver;
    private static WebDriverManager instance;
    private WebDriverWait wait;
    private final String baseUrl = "https://login.salesforce.com/";
    private static final int TIMEOUT_NORMAL = 15;
    private WebDriverManager() {
        initializeWebDriver();
    }
    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }
    private void initializeWebDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT_NORMAL);
        driver.get(baseUrl);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
