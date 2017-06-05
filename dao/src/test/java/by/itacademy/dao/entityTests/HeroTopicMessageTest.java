package by.itacademy.dao.entityTests;

import by.itacademy.entity.HeroTopic;
import by.itacademy.entity.HeroTopicMessage;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTopicMessageTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveReadTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        HeroTopicMessage message = new HeroTopicMessage();
        message.setUser(session.find(User.class, 3L));
        message.setTopic(session.find(HeroTopic.class, 3L));
        message.setText("I'm first");
        Long id = (Long) session.save(message);
        HeroTopicMessage savedMessage = session.find(HeroTopicMessage.class, id);
        assertEquals(message, savedMessage);
        transaction.commit();
        session.close();
    }


    @AfterClass
    public static void finist() {
        SESSION_FACTORY.close();
    }
}
