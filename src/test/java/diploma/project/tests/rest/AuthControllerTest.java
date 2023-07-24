package diploma.project.tests.rest;
import diploma.project.rest.AuthController;
import diploma.project.rest.entities.SignUpIn;
import org.testng.annotations.Test;
import java.io.IOException;

public class AuthControllerTest {
    AuthController authController = new AuthController();

    @Test (description = "Sign up test",
    priority = 10,
    groups = {"login"})

    public void SignUpTest() throws IOException {
        SignUpIn signUp = new SignUpIn();
        signUp.setUsername("yuliiap");
        signUp.setPassword("2147483647");
        signUp.setConfirmPassword("2147483647");

        authController.postSignUp(signUp);

    }
    @Test (description = "Sign in test",
            priority = 20,
            groups = {"login"})

    public void SignInTest() throws IOException {
        SignUpIn signIn = new SignUpIn();
        signIn.setUsername("yuliiap");
        signIn.setPassword("2147483647");

        authController.postSignIn(signIn);

    }
}
