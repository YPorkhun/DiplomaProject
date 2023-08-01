package diploma.project.rest.entities;
import diploma.project.wd.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditInfoDialogMenu extends ProfilePage {
    @FindBy (css = ".cdk-overlay-pane h2")
    private WebElement dialogMenuHeader;
    @FindBy (xpath = "//input[@formcontrolname='name']")
    private WebElement newUserName;
    @FindBy (xpath = "//input[@formcontrolname='lastname']")
    private WebElement newLastName;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'] [contains(text(),'Update')]")
    private WebElement updateButton;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'] [contains(text(),'Cancel')]")
    private WebElement cancelButton;

    public EditInfoDialogMenu (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getHeaderOfDialogMenu () {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cdk-overlay-pane h2")));
        return dialogMenuHeader.getText();
    }
   public EditInfoDialogMenu setNewUserName(String new_user_name) {
        newUserName.clear();
        newUserName.sendKeys(new_user_name);
        return this;
   }
    public EditInfoDialogMenu setNewLastName(String new_last_name) {
        newLastName.clear();
        newLastName.sendKeys(new_last_name);
        return this;
    }
    public ProfilePage clickUpdateButton () {
        updateButton.click();
        return new ProfilePage(driver);
    }
    public ProfilePage clickCancelButton(){
        updateButton.click();
        return new ProfilePage(driver);
    }
}
