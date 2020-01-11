package by.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class City {

    @Id
    private UUID id;

    @Column
    private String name;

    @OneToMany
    private List<CityStop> stops;

    @ManyToOne
    private Route routes;
}
