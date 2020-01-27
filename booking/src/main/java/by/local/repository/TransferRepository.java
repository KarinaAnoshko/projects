package by.local.repository;

import by.local.entity.Transfer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferRepository {

    @Autowired
    private SessionFactory factory;

    public void saveTransfer(Transfer transfer) {
        factory.getCurrentSession().saveOrUpdate(transfer);
    }
}
