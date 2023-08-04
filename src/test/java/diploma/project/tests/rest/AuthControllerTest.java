package diploma.project.tests.rest;
import com.beust.ah.A;
import diploma.project.rest.AuthController;
import diploma.project.rest.entities.Auth;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthControllerTest extends BaseTest {
    AuthController authController = new AuthController();
    @Test(priority = 10)
    public void SingInTest() throws IOException {
        System.out.println(auth.getToken());
        Assert.assertTrue(StringUtils.isNotEmpty(auth.getToken()), "Token is presented");
    }

    @Test(priority = 11)
    public void SingUpTest() throws IOException {
        Auth authorization = new Auth("yuliiaP", "blablabla12345password");
        authController.postSignUp(authorization,"blablabla12345password");

    }
}
