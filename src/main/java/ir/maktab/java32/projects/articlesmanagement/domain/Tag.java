package ir.maktab.java32.projects.articlesmanagement.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @ManyToMany(mappedBy = "tags")
    private Set<Article> articles = new HashSet<>();

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
