package by.local.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class City implements Serializable {


    private static final long serialVersionUID = -5395058674688773589L;

    @Id
    public static final UUID id = UUID.randomUUID();

    @Column
    private String name;

    @OneToMany
    private List<CityStop> stops;

    @ManyToOne
    private Route routes;

}
