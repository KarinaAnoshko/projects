package by.repository;

import by.entity.CityStop;
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
public class CityStopRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    CityStopRepository repository;

    protected CityStop createData() {
        CityStop cityStop = new CityStop();
        cityStop.setId(UUID.randomUUID());
        cityStop.setName("cinema");
        cityStop.setStreet("Angarskaya");
        cityStop.setHouse("80b");
        return cityStop;
    }

    protected List<CityStop> createCityList() {  //rewrite!
        CityStop first = new CityStop();
        first.setId(UUID.randomUUID());
        first.setName("Cinema");
        first.setStreet("Angarskaya");
        first.setHouse("80b");
        CityStop second = new CityStop();
        second.setId(UUID.randomUUID());
        second.setName("Theatre");
        second.setStreet("Nemiga");
        second.setHouse("810");
        CityStop third = new CityStop();
        third.setId(UUID.randomUUID());
        third.setName("Railway station");
        third.setStreet("Lenina");
        third.setHouse("35");
        List<CityStop> cityStops = new ArrayList<>();
        cityStops.add(first);
        cityStops.add(second);
        cityStops.add(third);
        return cityStops;
    }

    @Test
    @Transactional
    public void saveAndGetBooking() {
        CityStop cityStop = createData();
        repository.saveCity(cityStop);
        CityStop citySave = repository.findById(cityStop.getId());
        assertEquals(cityStop, citySave);
    }
}