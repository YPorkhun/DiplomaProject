package diploma.project.wd;
import diploma.project.rest.entities.EditInfoDialogMenu;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.util.List;

public class ProfilePage extends BasePage {
    @FindBy (tagName = "h1")
    private WebElement profileHeader;
    @FindBy (tagName = "h3")
    private WebElement editedInfoHeader;
    @FindBy(tagName = "mat-icon")
    private WebElement profileIconLocator;
    @FindBy (xpath =  "//span[@class='mat-button-wrapper'] [contains(text(),'Edit Info')]")
    private WebElement editInfoButton;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getHeader() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        return profileHeader.getText();
    }

    public String getNewHeader() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        return editedInfoHeader.getText();
    }

    public ProfilePage clickOnEditUserInfoButton () {
        clickButton(editInfoButton);
        return new EditInfoDialogMenu(driver);
    }
    public WelcomePage clickOnProfileIconAndLogout() {

        clickButton(profileIconLocator);

        Actions actions = new Actions(driver);
        List<WebElement> menuOptions = driver.findElements(By.xpath("//div[@class='mat-menu-content ng-tns-c16-0']"));
        for (WebElement option : menuOptions) {
            if (option.getText().contains("Profile")) {
                actions.moveToElement(option).pause(100)
                        .moveToElement(driver.findElement(By.xpath("//div//button[contains(text(),'Logout')]")))
                        .click()
                        .perform();
                break;
            }
        }
        return new WelcomePage(driver);
    }
}
