package by.local.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Route implements Serializable {

    private static final long serialVersionUID = -3089230758061448666L;

    @Id
    public static final UUID id = UUID.randomUUID();

    @Column
    private Date date;

    @OneToOne
    private Transfer transfer;

    @OneToMany
    private List<City> cities;

    @OneToMany
    private List<Booking> bookings;
}
