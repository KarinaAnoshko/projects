package by.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class AppUser {

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

