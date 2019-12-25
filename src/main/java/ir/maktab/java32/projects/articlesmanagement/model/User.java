package ir.maktab.java32.projects.articlesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
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

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
    private List<Article> articleList;
}
