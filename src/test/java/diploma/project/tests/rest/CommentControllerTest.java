package diploma.project.tests.rest;
import diploma.project.rest.CommentController;
import diploma.project.rest.entities.Comment;
import org.testng.annotations.Test;
import java.io.IOException;

public class CommentControllerTest {
    CommentController commentController = new CommentController();

    @Test(description = "Create new comment test",
            priority = 10
    )
    public void CreateCommentByJobIdTest () throws IOException {
        Comment comment = new Comment();
        comment.setId("1");
        comment.setMessage("Hello world!");
        comment.setUsername("yuliiap");
        comment.setCommentDate("2023-07-20 16:46:00");

        commentController.postCreateCommentByJobId(comment, "1");
    }

    @Test(description = "Get all comments test",
            priority = 20
    )
    public void CetCommentAll () throws IOException {
        commentController.getCommentAll("1");
    }
}
