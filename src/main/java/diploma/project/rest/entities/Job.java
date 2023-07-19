package diploma.project.rest.entities;
import lombok.Data;

@Data
public class Job {
    private Integer id;
    private String title;
    private String description;
    private Integer price;
    private String user;
    private Integer noOfComments;
}
