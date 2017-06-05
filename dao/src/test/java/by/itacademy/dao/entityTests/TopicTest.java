package by.itacademy.dao.entityTests;


import by.itacademy.entity.Topic;
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

public class TopicTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void createReadTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Topic topic = new Topic();
        topic.setName("Hello!");
        topic.setText("Hello");
        User user = session.find(User.class, 3L);
        topic.setUser(user);

        Long id = (Long) session.save(topic);
        Topic savedTopic = session.find(Topic.class, id);

        assertEquals(topic, savedTopic);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
