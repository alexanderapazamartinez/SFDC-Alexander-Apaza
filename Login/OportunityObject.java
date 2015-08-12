package Login;

import Settings.WebDriverManager;
import org.openqa.selenium.By;
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
public class OportunityObject {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    private WebElement oportunityName;

    @FindBy(xpath = "//div[@id='opp9_ileinner']")
    @CacheLookup
    private WebElement oportunityCloseDate;

    @FindBy(xpath = "//div[@id='opp11_ileinner']")
    @CacheLookup
    private WebElement oportunityStage;

    @FindBy(xpath = "//div[@id='opp4_ileinner']/descendant::a")
    @CacheLookup
    private WebElement oportunityAccount;


    public OportunityObject(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public String getOportunityName(){
        String oportunityNameResult ="";
        try {
                oportunityNameResult = oportunityName.getText();
            } catch (WebDriverException e) {
                throw new WebDriverException(e);
            } finally {
                driver.switchTo().defaultContent();
            }
        return oportunityNameResult;
    }
    public String getOportunityCloseDate(){
        String oportunityCloseDateResult ="";
        try {
                oportunityCloseDateResult = oportunityCloseDate.getText();
            } catch (WebDriverException e) {
                throw new WebDriverException(e);
            } finally {
                driver.switchTo().defaultContent();
            }
        return oportunityCloseDateResult;
    }
    public String getOportunityStage(){
        String oportunityStageResult ="";
            try {
                oportunityStageResult = oportunityStage.getText();
            } catch (WebDriverException e) {
                throw new WebDriverException(e);
            } finally {
                driver.switchTo().defaultContent();
            }
        return oportunityStageResult;

    }
    public String getOportunityAccount(){
        String oportunityAccountResult ="";
        try {
                oportunityAccountResult = oportunityAccount.getText();
            } catch (WebDriverException e) {
                throw new WebDriverException(e);
            } finally {
                driver.switchTo().defaultContent();
            }
        return oportunityAccountResult;
    }
    public void deleteOportunity(String oportunitToDelete){
        try {

            driver.findElement(By.cssSelector("a[title='Opportunities Tab']")).click();
            driver.findElement(By.linkText(oportunitToDelete)).click();
            driver.findElement(By.xpath("//input[@name='del']")).click();
        } catch (WebDriverException e) {
            System.out.println("Failed: Delete Oportunity button does not work");
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
