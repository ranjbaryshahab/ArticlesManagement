package ir.maktab.java32.projects.articlesmanagement.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", unique = true, nullable = false, length = 25)
    private String username;

    @Column(name = "national_code", nullable = false, length = 25)
    private String nationalCode;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_role", joinColumns={@JoinColumn(referencedColumnName="id")}
            , inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
    private Set<Role> roles = new HashSet<>();


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
