package ir.maktab.java32.projects.articlesmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "country", length = 15, nullable = false)
    private String country;

    @Column(name = "city", length = 15, nullable = false)
    private String city;

    @Column(name = "street", length = 15, nullable = false)
    private String street;

    @Column(name = "postalCode", length = 10, nullable = false)
    private String postalCode;

    @OneToOne(mappedBy = "address")
    private User user;
}
