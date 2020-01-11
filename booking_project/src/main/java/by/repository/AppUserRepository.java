package by.repository;

import by.entity.AppUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void saveAppUser(AppUser user) {
        sessionFactory.getCurrentSession()
                .persist(user);
    }

    public AppUser findById(String phoneNumber) {
        return sessionFactory.getCurrentSession()
                .get(AppUser.class, phoneNumber);
    }
}
