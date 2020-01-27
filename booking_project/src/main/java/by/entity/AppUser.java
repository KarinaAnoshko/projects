package by.entity;

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

    private static final long serialVersionUID = -2337417622730793978L;

    @Id
    private String phoneNumber;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private Role role;

    @OneToMany
    private List<Route> routes;

}

