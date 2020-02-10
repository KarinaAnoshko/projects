package by.local.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Transfer implements Serializable {

    private static final long serialVersionUID = -6634160726180031954L;

    @Id
    private String vehicleRegistrationNumber;

    @Column
    private String makeAndModel;

    @Column
    private String imageName;

    @Column
    private Integer numberOfSeats;

    @Column
    private Color color;

    @OneToOne
    private Route route;

}
