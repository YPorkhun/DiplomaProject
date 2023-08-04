package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Auth;
import okhttp3.*;
import java.io.IOException;

public class AuthController {
    public Auth postSignIn (Auth auth) throws IOException {
        Gson gson = new Gson();
        RequestBody body = RequestBody.create(gson.toJson(auth), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .post(body)
                .url("https://freelance.lsrv.in.ua/api/auth/signin")
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        Auth authResp = gson.fromJson(response.body().string(), Auth.class);
        auth.setToken(authResp.getToken());
        return auth;
    }
    public void postSignUp (Auth auth, String confirmPassword) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(auth).getBytes());
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
}
