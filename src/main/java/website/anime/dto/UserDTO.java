package website.anime.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDTO {

    private Integer userId;
    private String nickName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Integer> rolesID;
}
