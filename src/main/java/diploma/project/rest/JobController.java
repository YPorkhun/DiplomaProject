package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Job;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class JobController extends AuthController {
    public void postJobCreate (Job job) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(job).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/create")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void postJobDeleteByJobId (Job job, String id ) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(job).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/delete/" + id)
                .header("Content-Type", "application/json")
                .header("Authorization", token)
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void getJobById (String id) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/" + id)
                .header("Authorization", token)
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void getJobUserJobs () throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/user/jobs" )
                .header("Authorization", token)
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.body().string());
    }
    public void getJobAll () throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/all" )
                .header("Authorization", token)
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
