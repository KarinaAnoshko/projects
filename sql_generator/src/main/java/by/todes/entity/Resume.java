package by.todes.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "dateOfBirthday")
    private Date dateOfBirthday;

    @Column(name = "gander")
    private String gander;

    @Column(name = "contacts")
    private String[] contacts;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Technology> technologies;

    public Resume(){

    }

}
