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
public class OportunitiesTab {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "new")
    @CacheLookup
    private WebElement newOportunityForm;

    public OportunitiesTab(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public OportunitiesForm clickNewOportunitiesForm(){
        try {
            newOportunityForm.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new OportunitiesForm(driver);
    }
}
