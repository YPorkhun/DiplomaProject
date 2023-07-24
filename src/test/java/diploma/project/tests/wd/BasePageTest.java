package diploma.project.tests.wd;
import diploma.project.tests.listeners.CustomExtentReportsListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Listeners({CustomExtentReportsListener.class})

public class BasePageTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void creatingObjectOfBrowser(String browser) {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", new File("target/downloads").getAbsolutePath());
            options.setExperimentalOption("prefs", prefs);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
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
