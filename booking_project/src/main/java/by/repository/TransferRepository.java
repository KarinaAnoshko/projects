package by.repository;

import by.entity.Transfer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void saveTransfer(Transfer transfer) {
        sessionFactory.getCurrentSession()
                .persist(transfer);
    }

    public Transfer findById(String stateNumber) {
        return sessionFactory.getCurrentSession()
                .get(Transfer.class, stateNumber);
    }
}
