package diploma.project.tests.rest;
import diploma.project.rest.CommentController;
import diploma.project.rest.entities.Comment;
import diploma.project.rest.entities.Job;
import org.testng.annotations.Test;
import java.io.IOException;

public class CommentControllerTest {
    CommentController commentController = new CommentController();

    @Test(description = "Create new comment test",
            priority = 10,
            dependsOnGroups = {"login"}

    )
    public void CreateCommentByJobIdTest () throws IOException {
        Job job = new Job();
        job.setId(1);

        Comment comment = new Comment();
        comment.setId(1);
        comment.setMessage("Hello world!");
        comment.setUsername("yuliiap");
        comment.setCommentDate("2023-07-20 16:46:00");

        commentController.postCreateCommentByJobId(comment, job);
    }

    @Test(description = "Get all comments test",
            priority = 20,
            dependsOnGroups = {"login"}

    )
    public void CetCommentAll () throws IOException {
        Job job = new Job();
        job.setId(1);

        commentController.getCommentAll(job);
    }
}
