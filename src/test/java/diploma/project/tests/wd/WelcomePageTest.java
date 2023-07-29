package diploma.project.tests.wd;
import diploma.project.wd.LoginPage;
import diploma.project.wd.RegistrationPage;
import diploma.project.wd.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePageTest extends BasePageTest {

    @Test (groups = {"login"})
    public void WelcomeLoginTest () {
        WelcomePage welcomePage = new WelcomePage (driver);

        driver.get("https://freelance.lsrv.in.ua/home");
        LoginPage loginPage = welcomePage.clickLogInButton();

        Assert.assertEquals(loginPage.getTitle(),"Login");
    }

    @Test(groups = {"create_account"})
    public void WelcomeCreateAccountTest () {
        WelcomePage welcomePage = new WelcomePage (driver);

        driver.get("https://freelance.lsrv.in.ua/home");
        RegistrationPage registrationPage = welcomePage.clickCreateAccountButton();

        Assert.assertEquals(registrationPage.getTitle(),"Register");
    }
}
