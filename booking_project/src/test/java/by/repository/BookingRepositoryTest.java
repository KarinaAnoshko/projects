package by.repository;

import by.entity.AppUser;
import by.entity.Booking;
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
public class BookingRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    BookingRepository repository;

    protected List<AppUser> createListUser() {
        return new AppUserRepositoryTest().createList();
    }

    protected Booking createData() {
        AppUser user = new AppUserRepositoryTest().createData();
        Booking booking = new Booking();
        booking.setReserved_by(user);
        booking.setId(UUID.randomUUID());
        booking.setBookingSeat(1);
        booking.setStatus(false);
        return booking;
    }

    protected List<Booking> createBookingList() {
        List<AppUser> users = createListUser();
        Booking first = createData();
        Booking second = createData();
        second.setReserved_by(users.get(1));
        second.setBookingSeat(2);
        Booking third = createData();
        third.setReserved_by(users.get(2));
        third.setBookingSeat(3);
        List<Booking> bookings = new ArrayList<>();
        bookings.add(first);
        bookings.add(second);
        bookings.add(third);
        return bookings;
    }

    @Test
    @Transactional
    public void saveAndGetBooking() {
        Booking booking = createData();
        repository.saveBooking(booking);
        Booking bookingSave = repository.findById(booking.getId());
        assertEquals(booking, bookingSave);
    }

}