package by.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Route {

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
