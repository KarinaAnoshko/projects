package by.local.service;

import by.local.entity.Transfer;
import by.local.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService {

    private TransferRepository repository;


    @Autowired
    public TransferService(TransferRepository repository){
        this.repository = repository;
    }

    public void save(Transfer transfer) {
        repository.saveEntity(transfer);
    }

    public Transfer findById(String id){
        return repository.findById(id);
    }

    public void remove(String id) {
        repository.removeEntity(id);
    }

    public List<Transfer> findAll(){
        return repository.findAll();
    }


}