package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.SignUpIn;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class AuthController {
    protected String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyMSIsIm5hbWUiOm51bGwsImlkIjoiMjEiLCJ1c2VybmFtZSI6Inl1bGlpYVAiLCJsYXN0bmFtZSI6bnVsbCwiaWF0IjoxNjkwNzAzMjk4LCJleHAiOjE2OTA3MDY4OTh9.irqseErXlYboiJQGYS1SgAStKywt22zApgOPOlRjFihl4FaJzzT8Bda1wBZ6B8VzFrMQ3_kn5CAbWvRTwtt4Zg";

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
