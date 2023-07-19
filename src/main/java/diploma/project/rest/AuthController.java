package diploma.project.rest;

import com.google.gson.Gson;
import diploma.project.rest.entities.SignUpIn;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class AuthController {
    public void postSignUp (SignUpIn signUp) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(signUp).getBytes());
        Request request = new Request.Builder()
                .url("http://127.0.0.1:8080/api/auth/signup")
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
                .url("http://127.0.0.1:8080/api/auth/signin")
                .post(body)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
