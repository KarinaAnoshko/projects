package by.local.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class CityStop implements Serializable {

    private static final long serialVersionUID = 982700570253573211L;

    @Id
    public static final UUID id = UUID.randomUUID();

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String house;

    @ManyToOne
    private City city;
}
