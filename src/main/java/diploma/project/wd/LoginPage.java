package diploma.project.wd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "")
    private WebElement usernameLocator;
    @FindBy (xpath = "")
    private WebElement passwordLocator;
    @FindBy (xpath = "")
    private WebElement buttonLocator;

    public LoginPage (WebDriver driver){super(driver);
        PageFactory.initElements(driver, this);
    }


}
