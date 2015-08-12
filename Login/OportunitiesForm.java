package Login;

import Settings.WebDriverManager;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class OportunitiesForm {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement oportunityNamefield;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement oportunityCloseDataField;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement oportunityStageField;

    @FindBy(xpath = "//a[@id='opp4_lkwgt']")
    @CacheLookup
    private WebElement oportunityAccountField;

    @FindBy(xpath = "//input[@name='save']")
    @CacheLookup
    private WebElement saveOportunitiesButton;

    public OportunitiesForm(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public OportunitiesForm setOportunityName(String oportunityName){
     try {
            oportunityNamefield.sendKeys(oportunityName);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }
    public OportunitiesForm setCloseData(String date){
        try{
            oportunityCloseDataField.sendKeys(date);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }
    public OportunitiesForm setStage(String stage){
        try {
            Select select = new Select(oportunityStageField);
            select.selectByVisibleText(stage);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }
    public OportunitiesForm setAccount(String accountName){
        try {
        oportunityAccountField.click();
        LookUpAccount lookUpAccount = new LookUpAccount(driver);
        lookUpAccount.lookForAccount(accountName);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }
    public OportunityObject clickSaveOportunitiesButton(){
        try {
            saveOportunitiesButton.click();
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return new OportunityObject(driver);
    }

}
