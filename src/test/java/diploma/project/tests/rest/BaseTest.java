package diploma.project.tests.rest;

import diploma.project.rest.AuthController;
import diploma.project.rest.entities.Auth;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest {
    private static String login = "yuliiaP";
    private static String pass = "yuliiap12345";
    Auth auth;
    @BeforeMethod
    void setup() throws IOException {
        Auth auth = new Auth(login, pass);
        AuthController authController = new AuthController();
        this.auth = authController.postSignIn(auth);
    }
}
