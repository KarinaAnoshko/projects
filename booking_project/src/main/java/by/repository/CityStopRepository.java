package by.repository;

import by.entity.CityStop;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CityStopRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveCity(CityStop cityStop) {
        sessionFactory.getCurrentSession()
                .persist(cityStop);
    }

    public CityStop findById(UUID id) {
        return sessionFactory.getCurrentSession()
                .get(CityStop.class, id);
    }
}
