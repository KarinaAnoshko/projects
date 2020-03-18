package by.todes.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String phoneNumber;

    @Column
    private String additionalContact;

    @Column
    private String webSite;

    @ManyToOne
    private Resume resume;

}
