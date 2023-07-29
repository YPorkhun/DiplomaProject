package diploma.project.tests.rest;
import diploma.project.rest.UserController;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserControllerTest {
    UserController userController = new UserController();

    @Test ( description = "Get user and get user by id test",
            priority = 10
    )
    public void GetUserTest () throws IOException {
        userController.getUser();
        userController.getUserById(1);
    }
    @Test ( description = "Update user test",
            priority = 20
    )
    public void UserUpdateTest () throws IOException {
        userController.postUserUpdate();
    }
}
