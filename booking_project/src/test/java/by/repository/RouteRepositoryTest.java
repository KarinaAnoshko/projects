package by.repository;

import by.entity.Route;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = TestConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class RouteRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RouteRepository repository;

    protected Route createData() {
        Route route = new Route();
        route.setId(UUID.randomUUID());
        route.setDate(new Date());
        route.setTransfer(new TransferRepositoryTest().createData());
        route.setCities(new CityRepositoryTest().createCityList());
        route.setBookings(new BookingRepositoryTest().createBookingList());
        return route;
    }

    @Test
    @Transactional
    public void saveAndGetRoute() {
        Route route = createData();
        repository.saveRoute(route);
        Route savedRoute = repository.findById(route.getId());
        assertEquals(route, savedRoute);
    }

}