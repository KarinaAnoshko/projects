package by.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class City implements Serializable {

    private static final long serialVersionUID = 5183571120778627597L;

    @Id
    private UUID id;

    @Column
    private String name;

    @OneToMany
    private List<CityStop> stops;

    @ManyToOne
    private Route routes;
}
