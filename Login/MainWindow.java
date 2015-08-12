package Login;

import Settings.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alexander Apaza on 8/10/2015.
 */
public class MainWindow {
    WebDriver driver;
    WebDriverWait wait;
    public MainWindow(WebDriver driver){
        this.driver = driver;
        this.wait = WebDriverManager.getInstance().getWait();
    }
    public MenuBar goToMenuBar(){
        return new MenuBar(driver);
    }

}
