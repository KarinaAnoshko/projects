package by.repository;

import by.entity.Route;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RouteRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void saveRoute(Route route) {
        sessionFactory.getCurrentSession()
                .persist(route);
    }

    public Route findById(UUID id) {
        return sessionFactory.getCurrentSession()
                .get(Route.class, id);
    }
}
