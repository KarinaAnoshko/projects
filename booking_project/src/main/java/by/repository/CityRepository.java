package by.repository;

import by.entity.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CityRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveCity(City city) {
        sessionFactory.getCurrentSession()
                .persist(city);
    }

    public City findById(UUID id) {
        return sessionFactory.getCurrentSession()
                .get(City.class, id);
    }
}
