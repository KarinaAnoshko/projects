package by.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Booking {

    @Id
    private UUID id;

    @Column
    private Integer bookingSeat;

    @Column
    private Boolean status;

    @OneToOne
    @Nullable
    private AppUser reserved_by;

    @ManyToOne
    @Nullable
    private Route route;
}
