package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Comment;
import diploma.project.rest.entities.Job;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class CommentController {
    public void postCreateCommentByJobId (Comment comment, Job id) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(comment).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/comment/" + id + "/create")
                .post(body)
                .header("Content-Type", "application/json")
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

    public void getCommentAll (Job id) throws IOException {

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/comment/" + id + "/all")
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
