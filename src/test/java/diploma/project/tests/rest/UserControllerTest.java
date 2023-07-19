package diploma.project.tests.rest;
import diploma.project.rest.UserController;
import org.testng.annotations.Test;
import java.io.IOException;

public class UserControllerTest {
    @Test
    public void UserTest () throws IOException {
        UserController userController = new UserController();
        userController.getUser();
        userController.getUserById(1);
        userController.postUserUpdate();
    }
}
