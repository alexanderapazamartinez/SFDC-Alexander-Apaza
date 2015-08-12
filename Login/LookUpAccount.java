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
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class LookUpAccount {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(id = "searchFrame")
    @CacheLookup
    private WebElement searchFrame;

    @FindBy(id = "lksrch")
    @CacheLookup
    private WebElement txtAccountToFind;

    @FindBy(xpath = "//input[@id='lksrch']/following-sibling::input")
    @CacheLookup
    private WebElement buttonToFindAccount;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    private WebElement resultFrame;

    public LookUpAccount(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }
    public void lookForAccount(String accountToFind){
        try {
            Set<String> setWindows = driver.getWindowHandles();
            LinkedList<String> listWindows = new LinkedList<>(setWindows);
            driver.switchTo().window(listWindows.getLast());
            driver.switchTo().frame(searchFrame);
            String accountResult = "";
            txtAccountToFind.sendKeys(accountToFind);
            buttonToFindAccount.click();

            driver.switchTo().defaultContent();
            driver.switchTo().frame(resultFrame);
            driver.findElement(By.linkText(accountToFind)).click();
            driver.switchTo().window(listWindows.getFirst());

        } catch (WebDriverException e) {
            System.out.println("<<<<<<< The account:"+accountToFind+" you specified does not exit >>>>>>>>>>");
            driver.close();
        }


    }
}
