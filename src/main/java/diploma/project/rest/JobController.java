package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Job;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class JobController {

    public void postJobCreate (Job job) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(job).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/create")
                .post(body)
                .header("Content-Type", "application/json")
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
                .get()
                .build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
        System.out.println(response.body().string());
    }
}
