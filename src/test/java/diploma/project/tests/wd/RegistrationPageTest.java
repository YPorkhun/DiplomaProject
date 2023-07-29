package diploma.project.tests.wd;
import diploma.project.wd.RegistrationPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BasePageTest {
    @Test (dependsOnGroups = {"create_account"})
    public void RegistrationTest(){
        driver.get("https://freelance.lsrv.in.ua/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setUserName("yuliiaP");
        registrationPage.setName("Yuliia");
        registrationPage.setLastname("Porkhun");
        registrationPage.setPasswordAndConfirm("yuliiap12345");
        registrationPage.clickOnRegisterButton();



        registrationPage.clickOnSignInButton();

    }
}
