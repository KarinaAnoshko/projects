package by.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class CityStop implements Serializable {

    private static final long serialVersionUID = -3417309402190133511L;

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String street;

    @Column
    private String house;

}
