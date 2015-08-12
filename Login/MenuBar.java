package Login;

import Settings.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class MenuBar {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "a[title='Accounts Tab']")
    @CacheLookup
    private WebElement accountTab;

    @FindBy(css = "a[title='Opportunities Tab']")
    @CacheLookup
    private WebElement oportunitiesTab;

    public MenuBar(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public AccountTab goToUserAccountTab(){
        try{
        accountTab.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new AccountTab(driver);
    }
    public OportunitiesTab goToOportunitiesTab(){
     try {
            oportunitiesTab.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
            return new OportunitiesTab(driver);
    }
}
