package diploma.project.tests.rest;
import diploma.project.rest.UserController;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserControllerTest extends BaseTest {
    UserController userController = new UserController();

    @Test(description = "Get user and get user by id test",
            priority = 10
    )
    public void GetUserTest() throws IOException {
        userController.getUser(auth);
        Response response = userController.getUserById(auth, 1);
        Assert.assertEquals(response.code(), 200);
    }

    @Test(description = "Update user test",
            priority = 11
    )
    public void UserUpdateTest() throws IOException {
        Response response = userController.postUserUpdate(auth);
        Assert.assertEquals(response.code(), 200);

    }
}
