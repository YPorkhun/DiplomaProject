package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.SignUpIn;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class AuthController {
    protected String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyMSIsIm5hbWUiOm51bGwsImlkIjoiMjEiLCJ1c2VybmFtZSI6Inl1bGlpYVAiLCJsYXN0bmFtZSI6bnVsbCwiaWF0IjoxNjkwOTc5NjM4LCJleHAiOjE2OTA5ODMyMzh9.GBHnnibUCXnbf5lRmJyLa2VD--dHL4782dMouk-OP-_V_PxB4Erid_VOazRD_BzsYPrkSlDDeiH2uNPQ8bH9qw";

    public void postSignUp (SignUpIn signUp) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(signUp).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signup")
                .post(body)
                .header("Content-Type", "application/json")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void postSignIn (SignUpIn signIn) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(signIn).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .post(body)
                .header("Content-Type", "application/json")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
