package diploma.project.tests.rest;
import diploma.project.rest.JobController;
import diploma.project.rest.entities.Job;
import org.testng.annotations.Test;
import java.io.IOException;

public class JobControllerTest {
    JobController jobController = new JobController();

        @Test(description = "Create job test",
                priority = 10)
        public void CreateJobTest () throws IOException {
            Job job = new Job();
            job.setId(1);
            job.setTitle("Some title");
            job.setDescription("Some interesting description");
            job.setPrice(100000);
            job.setUser("yuliiap");
            job.setNoOfComments(1);

            jobController.postJobCreate(job);
        }

        @Test(description = "Delete job test",
                priority = 10)
        public void DeleteJobTest () throws IOException {
            Job job = new Job();
            job.setId(79);
            job.setTitle("Some title");
            job.setDescription("Some interesting description");
            job.setPrice(100000);
            job.setUser("yuliiap");
            job.setNoOfComments(1);

            jobController.postJobDeleteByJobId(job, "1");

        }
        @Test(description = "Get job by id, get user's job, get all job tests",
                priority = 10)
        public void GetJobTest () throws IOException {
            jobController.getJobById("1");
            jobController.getJobUserJobs();
            jobController.getJobAll();
        }
    }