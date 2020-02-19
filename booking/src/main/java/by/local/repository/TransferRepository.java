package by.local.repository;

import by.local.entity.Transfer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransferRepository {

    private EntityManager manager;

    @PersistenceContext
    public void setManager(EntityManager manager) {
        this.manager = manager;
    }



    public void saveEntity(Transfer entity) {
        manager.persist(entity);
    }


    public void saveAll(List<Transfer> list) {
        list.forEach(transfer -> manager.persist(transfer));
    }


    public Transfer findById(Object id) {
        return manager.find(Transfer.class, id);
    }


    public Transfer getReference(Object id) {
        return manager.getReference(Transfer.class, id);
    }


    public List<Transfer> findAll(){
        return manager.createQuery("from Transfer", Transfer.class)
                .getResultList();
    }


    public void removeEntity(Object id) {
        manager.remove(findById(id));
    }

}
