package diploma.project.tests.rest;
import diploma.project.rest.AuthController;
import diploma.project.rest.JobController;
import diploma.project.rest.entities.Auth;
import diploma.project.rest.entities.Job;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class JobControllerTest extends BaseTest {
    JobController jobController = new JobController();
    private static String jobId = String.valueOf(1);


    @Test(description = "Create job test",
                priority = 20)
        public void CreateJobTest () throws IOException {
            Job job = new Job();
            job.setId(1);
            job.setTitle("Some title");
            job.setDescription("Some interesting description");
            job.setPrice(100000);
            Job someJob = jobController.postJobCreate(auth, job);
            Assert.assertEquals(job.getPrice(), someJob.getPrice());
        }

        @Test(description = "Delete job test",
                priority = 21)
        public void DeleteJobTest () throws IOException {
            JobController jobController = new JobController();
            Job job = new Job();
            job.setDescription("Some interesting description");
            job.setTitle("Some title");
            job.setId(12);
            Response response = jobController.postJobDeleteByJobId(auth, jobId);
        }
        @Test(description = "Get job by id, get user's job, get all job tests",
                priority = 22)
        public void GetJobTest () throws IOException {
            jobController.getJobById(auth,"1");
            jobController.getJobUserJobs(auth);
            Response response = jobController.getJobAll(auth);
            Assert.assertEquals(response.code(), 200);
        }
    }