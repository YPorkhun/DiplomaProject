package diploma.project.tests.wd;
import diploma.project.rest.entities.CommentMenu;
import diploma.project.wd.LoginPage;
import diploma.project.wd.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTest extends BasePageTest {

    @Test(priority = 10)
    public void LoginAndCreateCommentTest() {
        driver.get("https://freelance.lsrv.in.ua/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("yuliiaP");
        loginPage.setPassword("yuliiap12345");
        loginPage.clickOnLoginButton();

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnViewInfoButton();

        CommentMenu commentMenu = new CommentMenu(driver);
        commentMenu.writeComment("bla bla bla test comment");
        commentMenu.clickOnLeaveCommentButton();
        Assert.assertEquals(commentMenu.checkCommentCreated(),"Posted by New_User New_LastName");
        commentMenu.clickOnCloseJobDetailButton();
    }
}
