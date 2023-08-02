package diploma.project.rest.entities;

import diploma.project.wd.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentMenu extends MainPage {
    @FindBy(xpath = "//textarea[@formcontrolname='message']")
    private WebElement commentField;
    @FindBy (xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Leave comment')]")
    private WebElement leaveCommentButton;
    @FindBy (css = "div.mat-card-header-text>.mat-card-subtitle")
    private WebElement addedByHeader;
    @FindBy(xpath = "//span[@class='mat-button-wrapper'][contains(text(),'Close job details')]")
    private WebElement closeJobDetailButton;

    public CommentMenu (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public CommentMenu writeComment (String comment) {
        commentField.clear();
        commentField.sendKeys(comment);
        return this;
    }
    public CommentMenu clickOnLeaveCommentButton(){
        clickButton(leaveCommentButton);
        return this;
    }
    public String checkCommentCreated(){
        return addedByHeader.getText();
    }

    public MainPage clickOnCloseJobDetailButton(){
        clickButton(closeJobDetailButton);
        return new MainPage(driver);
    }
}
