package by.repository;

import by.entity.Color;
import by.entity.Transfer;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = TestConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class TransferRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    TransferRepository repository;

    protected Transfer createData() {
        Transfer transfer = new Transfer();
        transfer.setStateNumber("0072-MN4");
        transfer.setNumberOfSeats(17);
        transfer.setColor(Color.BLACK);
        return transfer;
    }

    @Test
    @Transactional
    public void saveAndGetTransfer() {
        Transfer transfer = createData();
        repository.saveTransfer(transfer);
        Transfer savedTransfer = repository.findById(transfer.getStateNumber());
        assertEquals(transfer, savedTransfer);
    }

}