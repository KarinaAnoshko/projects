package by.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Route implements Serializable {

    private static final long serialVersionUID = -3556298143097630744L;

    @Id
    private UUID id;

    @Column
    private Date date;

    @OneToOne
    private Transfer transfer;

    @OneToMany
    private List<City> cities;

    @OneToMany
    private List<Booking> bookings;

}
