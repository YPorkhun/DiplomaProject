package diploma.project.tests.wd;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BasePageTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void creatingObjectOfBrowser(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else throw new Error("You should creating an object of browser class");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void clearUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
