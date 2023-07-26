package diploma.project.tests.wd;
import diploma.project.wd.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {

    @Test
    public void LoginTest() {
        driver.get("https://freelance.lsrv.in.ua/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("yuliiap");
        loginPage.setPassword("yuliiap");
        loginPage.clickOnLoginButton();

    }
}
