package diploma.project.tests.wd;
import diploma.project.rest.entities.CreateJobMenu;
import diploma.project.wd.LoginPage;
import diploma.project.wd.MainPage;
import diploma.project.wd.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTest extends BasePageTest {

    @Test(priority = 10)
    public void LoginAndCreateNewJobTest() {
        driver.get("https://freelance.lsrv.in.ua/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("yuliiaP");
        loginPage.setPassword("yuliiap12345");
        loginPage.clickOnLoginButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnProfileIconAndNavigateProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        Assert.assertEquals(profilePage.getHeader(),"Profile");
        profilePage.clickOnAddJobButton();

        CreateJobMenu createJobMenu = new CreateJobMenu(driver);
        createJobMenu.setTitle("Hello world!");
        createJobMenu.setDescription("This is my description");
        createJobMenu.setPrice("10000");
        createJobMenu.clickOnCreateJobButton();

        Assert.assertEquals(createJobMenu.getHeaderOfJobCard(),"Hello world!");
}
}
