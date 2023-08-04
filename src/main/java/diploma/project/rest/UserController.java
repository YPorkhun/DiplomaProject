package diploma.project.rest;
import diploma.project.rest.entities.Auth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import java.io.IOException;

public class UserController  {
    public Response getUser(Auth auth) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/")
                .get()
                .header("Authorization", auth.getToken())
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        return response;
    }
    public Response getUserById (Auth auth, int id) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/" + id )
                .get()
                .header("Authorization", auth.getToken())
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        return response;
    }
    public Response postUserUpdate(Auth auth) throws IOException {
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("username", "yuliiaP");
        json.put("name", "New_User");
        json.put("lastname", "New_LastName");

        RequestBody body = RequestBody.create(json.toString().getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/user/update")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", auth.getToken())
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
        return response;
    }
}
