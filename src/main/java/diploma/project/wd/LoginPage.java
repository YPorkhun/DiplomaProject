package diploma.project.wd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "mat-input-0")
    private WebElement usernameLocator;
    @FindBy (id = "mat-input-1")
    private WebElement passwordLocator;
    @FindBy (className = "mat-button-wrapper")
    private WebElement logInButtonLocator;

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
    public LoginPage clickOnLoginButton() {
        clickButton(logInButtonLocator);
        return this;
    }
}
