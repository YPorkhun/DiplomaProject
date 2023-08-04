package diploma.project.tests.rest;
import diploma.project.rest.AuthController;
import diploma.project.rest.CommentController;
import diploma.project.rest.entities.Comment;
import diploma.project.rest.entities.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;

public class CommentControllerTest extends BaseTest  {
    CommentController commentController = new CommentController();
    @Test(description = "Create new comment test",
            priority = 30
    )
    public void CreateCommentByJobIdTest () throws IOException {
        Comment comment = new Comment();
        comment.setId("1");
        comment.setMessage("Hello world!");
        comment.setUsername("yuliiap");
        comment.setCommentDate("2023-07-20 16:46:00");
        Comment com = commentController.postCreateCommentByJobId(auth, comment, "1");
        System.out.println(com);
        Assert.assertEquals(com.getMessage(), comment.getMessage());
    }

    @Test(description = "Get all comments test",
            priority = 31
    )
    public void CetCommentAll () throws IOException {
        Comment[] com = commentController.getCommentAll(auth, "1");
        System.out.println(Arrays.toString(com));

    }
}
