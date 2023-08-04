package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Auth;
import diploma.project.rest.entities.Comment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class CommentController {

    public Comment postCreateCommentByJobId (Auth auth, Comment comment, String jobId) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(comment).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/comment/" + jobId + "/create")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", auth.getToken())
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        Comment newComment = new Gson().fromJson(response.body().string(), Comment.class);
        return newComment;
    }

    public Comment[] getCommentAll (Auth auth, String jobId) throws IOException {

        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/comment/" + jobId + "/all")
                .header("Authorization", auth.getToken())
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        Comment[] comments = new Gson().fromJson(response.body().string(), Comment[].class);
        return comments;
    }
}
