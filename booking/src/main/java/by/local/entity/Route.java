package by.local.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
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
