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
public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "username")
    @CacheLookup
    private WebElement userNameText;

    @FindBy(id = "password")
    @CacheLookup
    private WebElement passwordText;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);

    }
    public LoginPage setUserNameText(String username){
        try {
                //wait.until(ExpectedConditions.visibilityOfElementLocated((By)userNameText));
                userNameText.clear();
                userNameText.sendKeys(username);
            } catch (WebDriverException e) {
                throw new WebDriverException(e);
            } finally {
                driver.switchTo().defaultContent();
            }
        return this;
    }
    public LoginPage setPasswordText(String password){
        try {
        //wait.until(ExpectedConditions.visibilityOf(passwordText));
        passwordText.clear();
        passwordText.sendKeys(password);
        } catch (WebDriverException e) {
            throw new WebDriverException(e);
        } finally {
            driver.switchTo().defaultContent();
        }
        return this;
    }
    public MainWindow clickLoginButton(){
        loginButton.click();
        return new MainWindow(driver);
    }


}
