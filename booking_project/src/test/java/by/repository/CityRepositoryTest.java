package by.repository;

import by.entity.City;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = TestConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class CityRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CityRepository repository;

    protected City createData() {
        CityStopRepositoryTest stopsTest = new CityStopRepositoryTest();
        City city = new City();
        city.setId(UUID.randomUUID());
        city.setName("Minsk");
        city.setStops(stopsTest.createCityList());
        return city;
    }

    protected List<City> createCityList() {
        City first = createData();
        City second = createData();
        second.setName("Grodno");
        City third = createData();
        third.setName("Pinsk");
        List<City> cities = new ArrayList<>();
        cities.add(first);
        cities.add(second);
        cities.add(third);
        return cities;
    }

    @Test
    @Transactional
    public void saveAndGetCity() {
        City city = createData();
        repository.saveCity(city);
        City saveCity = repository.findById(city.getId());
        assertEquals(city, saveCity);
        assertEquals(city.getId(), saveCity.getId());
    }

}