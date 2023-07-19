package diploma.project.tests.rest;
import diploma.project.rest.AuthController;
import diploma.project.rest.entities.SignUpIn;
import org.testng.annotations.Test;
import java.io.IOException;

public class AuthControllerTest {
    @Test (description = "",
    priority = 10)
    public void SignUpTest() throws IOException {
        SignUpIn signUpIn = new SignUpIn();
        signUpIn.setUsername("yuliiap");
        signUpIn.setPassword("test");
        signUpIn.setConfirmPassword("test");

        AuthController authController = new AuthController();
        authController.postSignUp(signUpIn);
        authController.postSignIn(signUpIn);

    }
}
