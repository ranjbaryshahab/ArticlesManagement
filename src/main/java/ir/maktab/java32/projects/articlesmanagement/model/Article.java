package ir.maktab.java32.projects.articlesmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "brief", length = 15, nullable = false)
    private String brief;

    @Column(name = "content", length = 254, nullable = false)
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "isPublished")
    private Boolean isPublished;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;
}
