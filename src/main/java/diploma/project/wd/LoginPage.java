package diploma.project.wd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "mat-input-0")
    private WebElement usernameLocator;
    @FindBy (id = "mat-input-1")
    private WebElement passwordLocator;
    @FindBy (className = "mat-button-wrapper")
    private WebElement logInButtonLocator;
    @FindBy (tagName = "h2")
    private WebElement loginHeader;

    public LoginPage (WebDriver driver){super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserName(String username) {
        usernameLocator.clear();
        usernameLocator.sendKeys(username);
        return this;
    }
    public LoginPage setPassword(String password) {
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        return this;
    }
    public MainPage clickOnLoginButton() {
        clickButton(logInButtonLocator);
        return new MainPage(driver);
    }
    public String getTitle () {
      return loginHeader.getText();
    }
}
