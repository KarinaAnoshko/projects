package by.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Data
public class Transfer implements Serializable {

    private static final long serialVersionUID = -8547748056872113744L;

    @Id
    private String stateNumber;

    @Column
    private Integer numberOfSeats;

    @Column
    private Color color;

    @OneToOne
    private Route route;
}
