package by.local.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class City implements Serializable {


    private static final long serialVersionUID = -5395058674688773589L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String name;

    @OneToMany
    private List<CityStop> stops;

    @ManyToOne
    private Route routes;

}
