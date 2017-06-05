package by.itacademy.dao.entityTests;

import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroTopic;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTopicTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveReadTopicHeroTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        HeroTopic topic = new HeroTopic();
        topic.setUser(session.find(User.class, 3L));
        topic.setName("Hello from test");
        topic.setText("HI!");
        topic.setHero(session.find(Hero.class, 4L));
        Long id = (Long) session.save(topic);
        HeroTopic savedTopicHero = session.find(HeroTopic.class, id);
        assertEquals(topic, savedTopicHero);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
