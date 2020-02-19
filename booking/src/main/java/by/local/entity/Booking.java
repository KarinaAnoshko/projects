package by.local.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
public class Booking implements Serializable {

    private static final long serialVersionUID = -6862606964536262566L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
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
