package diploma.project.tests.wd;
import diploma.project.wd.RegistrationPage;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BasePageTest {
    @Test
    public void RegistrationTest(){
        driver.get("https://freelance.lsrv.in.ua/register");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setUserName("yuliiap");
        registrationPage.setName("Yuliia");
        registrationPage.setLastname("Porkhub");
        registrationPage.setPasswordAndConfirm("yuliiap");
        registrationPage.clickOnRegisterButton();


    }
}
