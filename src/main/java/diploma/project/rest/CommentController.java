package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Comment;
import diploma.project.rest.entities.Job;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class CommentController extends AuthController {

    public void postCreateCommentByJobId (Comment comment, String id) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(comment).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/comment/" + id + "/create")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public void getCommentAll (String id) throws IOException {

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/comment/" + id + "/all")
                .header("Authorization", token)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
