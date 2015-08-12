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
public class    AccountForm {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement setAccountName;
    public AccountForm(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public AccountForm setAccountName(String accountName){
     try {
        setAccountName.sendKeys(accountName);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }
    public AccountForm clickCreateAccountButton(){
        driver.findElement(By.name("save")).click();
        return this;

    }

    public void deleteAccount(String accountToDelete){
        try {
            driver.findElement(By.cssSelector("a[title='Accounts Tab']")).click();
            driver.findElement(By.linkText(accountToDelete)).click();
            driver.findElement(By.xpath("//input[@name='delete']")).click();
        } catch (WebDriverException e) {
            System.out.println("Failed: Delete Account button does not work");
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}
