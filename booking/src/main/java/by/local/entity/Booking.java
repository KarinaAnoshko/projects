package by.local.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Booking implements Serializable {

    private static final long serialVersionUID = -6862606964536262566L;

    @Id
    public static final UUID id = UUID.randomUUID();

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
