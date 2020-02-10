package by.local.repository;

import by.local.entity.Transfer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransferRepository {

    private SessionFactory factory;

    @Autowired
    public void setFactory(SessionFactory factory){
        this.factory = factory;
    }

    public void saveTransfer(Transfer transfer) {
        factory.getCurrentSession().saveOrUpdate(transfer);
    }

    public Transfer findById(String id){
        return factory.getCurrentSession().get(Transfer.class, id);
    }

    public List<Transfer> findAll(){
        return factory.getCurrentSession()
                .createQuery("from Transfer", Transfer.class)
                .getResultList();
    }

    public void removeTransfer(String id) {
        factory.getCurrentSession().delete(findById(id));
    }

}
