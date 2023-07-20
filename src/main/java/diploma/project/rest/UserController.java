package diploma.project.rest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class UserController {

    public void getUser() throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/")
                .get()
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
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public void postUserUpdate() throws IOException {
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("username", "yuliiap");
        json.put("name", "Yuliia");
        json.put("lastname", "Porkhun");

        RequestBody body = RequestBody.create(json.toString().getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/update")
                .post(body)
                .header("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
