package by.repository;

import by.entity.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class BookingRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveBooking(Booking booking) {
        sessionFactory.getCurrentSession()
                .persist(booking);
    }

    public Booking findById(UUID id) {
        return sessionFactory.getCurrentSession()
                .get(Booking.class, id);
    }

    public List<Booking> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Booking", Booking.class)
                .getResultList();
    }


}