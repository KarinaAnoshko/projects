package by.local.repository;

import by.local.entity.Color;
import by.local.entity.Transfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;


@ContextConfiguration(classes = TestConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class TransferRepositoryTest {

    @Autowired
    TransferRepository repository;

    public Transfer createData(){
        Transfer transfer = new Transfer();
        transfer.setColor(Color.BLUE);
        transfer.setMakeAndModel("Mercedes mini-bus");
        transfer.setVehicleRegistrationNumber("1234 AA-7");
        return transfer;
    }

    @Test
    public void save(){
        Transfer transfer = createData();
        repository.saveEntity(transfer);
        Transfer expected = repository.findById(transfer.getVehicleRegistrationNumber());
        assertEquals(expected.getVehicleRegistrationNumber(), transfer.getVehicleRegistrationNumber());
    }

}