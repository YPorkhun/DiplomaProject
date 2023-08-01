package diploma.project.tests.wd;
import diploma.project.rest.entities.EditInfoDialogMenu;
import diploma.project.wd.LoginPage;
import diploma.project.wd.MainPage;
import diploma.project.wd.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest extends BasePageTest {

    @Test (priority = 10)
    public void LoginAndChangeProfileInfoTest() {
        driver.get("https://freelance.lsrv.in.ua/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("yuliiaP");
        loginPage.setPassword("yuliiap12345");
        loginPage.clickOnLoginButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnProfileIconAndNavigateProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertEquals(profilePage.getHeader(),"Profile");

        profilePage.getHeader();
        profilePage.clickOnEditUserInfoButton();

        EditInfoDialogMenu editInfoDialogMenu = new EditInfoDialogMenu(driver);
        Assert.assertEquals(editInfoDialogMenu.getHeaderOfDialogMenu(),"Edit User Profile");

        editInfoDialogMenu.setNewUserName("New_User");
        editInfoDialogMenu.setNewLastName("New_LastName");
        editInfoDialogMenu.clickUpdateButton();

        Assert.assertEquals(profilePage.getNewHeader(),"New_User New_LastName");
        profilePage.clickOnProfileIconAndLogout();
    }
}
