package diploma.project.rest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class UserController {
    public static String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyNiIsIm5hbWUiOm51bGwsImlkIjoiMjYiLCJ1c2VybmFtZSI6Inl1bGlpYVAiLCJsYXN0bmFtZSI6bnVsbCwiaWF0IjoxNjkwNjU3MjcxLCJleHAiOjE2OTA2NjA4NzF9.RNJyqhC50aJm5lTZb-5Zrc3a2xLpjqEydsnUpXq0NbLRDdzOPiGL2PiYR3jZoK--09Pesl69_KMHCB9ftEULDw";

    public void getUser() throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/")
                .get()
                .header("Authorization", token)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void getUserById (int id) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/" + id )
                .get()
                .header("Authorization", token)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public void postUserUpdate() throws IOException {
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("username", "yuliiaP");
        json.put("name", "Yuliia");
        json.put("lastname", "Porkhun");

        RequestBody body = RequestBody.create(json.toString().getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/update")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
