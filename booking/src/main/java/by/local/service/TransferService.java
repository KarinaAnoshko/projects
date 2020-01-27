package by.local.service;

import by.local.entity.Transfer;
import by.local.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    private TransferRepository repository;

    public void save(Transfer transfer) {
        repository.saveTransfer(transfer);
    }
}
