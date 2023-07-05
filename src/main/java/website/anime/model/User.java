package website.anime.model;

import java.util.List;

import org.springframework.beans.BeanUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    @NotEmpty
    @Email(message = "{error.invalid_email}")
    private String email;

    private String password;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
    private List<Role> roles;
    private String nickName;

    public User() {
    }

    public User(User user) {
        BeanUtils.copyProperties(user, this);
    }
}
