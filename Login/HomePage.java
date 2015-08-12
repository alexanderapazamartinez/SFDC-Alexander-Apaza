package Login;

import Settings.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    public HomePage(){
        driver = WebDriverManager.getInstance().getDriver();
        wait = WebDriverManager.getInstance().getWait();

    }
    public  LoginPage clickLoginButton(){
         return new LoginPage(driver);
    }

}
