package by.local.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class AppUser implements Serializable {

    private static final long serialVersionUID = -5997278914885679990L;

    @Id
    private String email;

    @Column
    private String password;

    @Column
    private String phoneNumber;

    @Column
    private AppRole role;

    @OneToMany
    private List<Route> routes;
}
