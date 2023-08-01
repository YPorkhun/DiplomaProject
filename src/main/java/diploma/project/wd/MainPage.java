package diploma.project.wd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends BasePage {
    @FindBy(tagName = "mat-icon")
    private WebElement profileIconLocator;

    public MainPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProfilePage clickOnProfileIconAndNavigateProfilePage() {

        clickButton(profileIconLocator);

        Actions actions = new Actions(driver);
        List<WebElement> menuOptions = driver.findElements(By.xpath("//div[@class='mat-menu-content ng-tns-c16-0']"));
        for (WebElement option : menuOptions) {
            if (option.getText().contains("Profile")) {
                actions.moveToElement(option).pause(100)
                        .moveToElement(driver.findElement(By.xpath("//div//button[contains(text(),'Profile')]")))
                        .click()
                        .perform();
                break;
            }
        }
        return new ProfilePage(driver);
    }
}
