package diploma.project.wd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    public  BasePage (WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait (driver, Duration.ofSeconds(10));
    }
    protected void clickButton (WebElement button) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

}


