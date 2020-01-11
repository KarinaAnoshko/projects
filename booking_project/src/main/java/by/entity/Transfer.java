package by.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Transfer {

    @Id
    private String stateNumber;

    @Column
    private Integer numberOfSeats;

    @Column
    private Color color;

    @OneToOne
    private Route route;
}
