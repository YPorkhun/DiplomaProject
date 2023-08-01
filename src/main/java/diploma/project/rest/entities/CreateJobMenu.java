package diploma.project.rest.entities;
import diploma.project.wd.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateJobMenu extends ProfilePage {
    @FindBy(xpath = "//input[@formcontrolname='title']")
    private WebElement title;
    @FindBy (xpath = "//textarea[@formcontrolname='description']")
    private WebElement description;
    @FindBy (xpath = "//input[@formcontrolname='price']")
    private WebElement price;
    @FindBy(xpath = "//span[text()=' Create job ']/parent::button")
    private WebElement createJobButton;


    public CreateJobMenu (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public CreateJobMenu setTitle(String someTitle){
        title.clear();
        title.sendKeys(someTitle);
        return this;
    }
    public CreateJobMenu setDescription (String someDescription){
        description.clear();
        description.sendKeys(someDescription);
        return this;
    }
    public CreateJobMenu setPrice (String somePrice){
        price.clear();
        price.sendKeys(somePrice);
        return this;
    }

    public String getHeaderOfJobCard() {
        return driver.findElement(By.xpath("//mat-card-title[@class='mat-card-title'][1]")).getText();
}
    public ProfilePage clickOnCreateJobButton () {
        clickButton(createJobButton);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > app-root > div > app-profile > div > div.row > app-my-jobs > div > mat-card")));
        return new ProfilePage(driver);
    }
}
