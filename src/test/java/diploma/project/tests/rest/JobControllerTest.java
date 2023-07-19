package diploma.project.tests.rest;
import diploma.project.rest.JobController;
import diploma.project.rest.entities.Job;
import org.testng.annotations.Test;
import java.io.IOException;

public class JobControllerTest {
    @Test
    public void JobTest () throws IOException {
        Job job = new Job();
        job.setId(4);
        job.setTitle("Some title");
        job.setDescription("Some interesting description");
        job.setPrice(100000);
        job.setUser("yuliiap");
        job.setNoOfComments(7);

        JobController jobController = new JobController();
        jobController.postJobCreate(job);
        jobController.postJobDeleteByJobId("1");
        jobController.getJobById("3");
        jobController.getJobUserJobs();
        jobController.getJobAll();
    }
}
