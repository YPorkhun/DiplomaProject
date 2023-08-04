package diploma.project.rest;
import com.google.gson.Gson;
import diploma.project.rest.entities.Job;
import diploma.project.rest.entities.Auth;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class JobController  {
    public Job postJobCreate (Auth auth, Job job) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(job).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/create")
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", auth.getToken())
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        Job jobResp = gson.fromJson(response.body().string(), Job.class);
        return jobResp;
    }
    public Response postJobDeleteByJobId (Auth auth, String jobId ) throws IOException {
        Gson gson = new Gson();

        RequestBody body = RequestBody.create(gson.toJson(jobId).getBytes());
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/delete/" + jobId)
                .header("Content-Type", "application/json")
                .header("Authorization", auth.getToken())
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response;

    }
    public Response getJobById (Auth auth, String jobId) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/" + jobId)
                .header("Authorization", auth.getToken())
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response;
    }
    public Response getJobUserJobs (Auth auth) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/user/jobs" )
                .header("Authorization", auth.getToken())
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response;

    }
    public Response getJobAll (Auth auth) throws IOException {
        Request request = new Request.Builder()
                .url("https://freelance.lsrv.in.ua/api/job/all" )
                .header("Authorization", auth.getToken())
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        return response;

    }
}
