package diploma.project.rest.entities;
import lombok.Data;

@Data
public class Comment {
    public Integer id;
    public String message;
    public String username;
    public String commentDate;
}
