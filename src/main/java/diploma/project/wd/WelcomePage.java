package diploma.project.wd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends BasePage  {
    @FindBy(linkText = "/login")
    private WebElement loginLocator;
    @FindBy(linkText = "/register")
    private WebElement createAccountLocator;

    public WelcomePage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public LoginPage clickLogInButton () {
        clickButton(loginLocator);
        return new LoginPage(driver);
    }
    public RegistrationPage clickCreateAccountButton() {
        clickButton(createAccountLocator);
        return new RegistrationPage(driver);
    }
}
