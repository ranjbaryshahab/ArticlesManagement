package ir.maktab.java32.projects.articlesmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "date")
    private Date date;

    @Column(name = "action")
    private String action;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", username=" + username + '\'' +
                ", action='" + action + '\'' +
                ", date='" + date +
                '}';
    }
}
