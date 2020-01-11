package by.repository;

import by.entity.AppUser;
import by.entity.Role;
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
public class AppUserRepositoryTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    AppUserRepository repository;

    protected AppUser createData() {
        AppUser user = new AppUser();
        user.setPhoneNumber("445413242");
        user.setEmail("anoshko.karina@gmail.com");
        user.setRole(Role.PASSENGER);
        user.setPassword(UUID.randomUUID().toString());
        return user;
    }

    protected List<AppUser> createList() {
        AppUser first = createData();
        AppUser second = createData();
        second.setPhoneNumber("291044217");
        AppUser third = createData();
        third.setPhoneNumber("293280289");
        List<AppUser> users = new ArrayList<>();
        users.add(first);
        users.add(second);
        users.add(third);
        return users;
    }

    @Test
    @Transactional
    public void saveAndGetUser() {
        AppUser user = createData();
        repository.saveAppUser(user);
        AppUser savedUser = repository.findById(user.getPhoneNumber());
        assertEquals(user, savedUser);
        assertEquals(user.getPhoneNumber(), savedUser.getPhoneNumber());
    }
}