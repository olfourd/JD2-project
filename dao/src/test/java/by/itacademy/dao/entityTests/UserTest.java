package by.itacademy.dao.entityTests;

import by.itacademy.entity.User;
import by.itacademy.entity.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().configure().buildSessionFactory();
    }

    @Test
    public void createReadUserTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User("qwerty", "qwerty", "qwerty", "qwerty", UserRole.USER);
        Long id = (Long) session.save(user);
        User savedUser = session.find(User.class, id);

        assertEquals(user, savedUser);

        transaction.commit();
        session.close();

    }


    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
