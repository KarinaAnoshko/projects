package by.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
public class CityStop {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String house;

}
