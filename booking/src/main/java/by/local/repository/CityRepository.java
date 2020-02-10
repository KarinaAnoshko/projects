package by.local.repository;

import by.local.entity.City;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CityRepository {

    private SessionFactory factory;

    @Autowired
    public void setFactory(SessionFactory factory){
        this.factory = factory;
    }

    public void saveCity(City city) {
        factory.getCurrentSession().saveOrUpdate(city);
    }

    public City findById(String id){
        return factory.getCurrentSession().get(City.class, id);
    }


}
