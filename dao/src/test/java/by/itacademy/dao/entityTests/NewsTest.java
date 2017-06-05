package by.itacademy.dao.entityTests;

import by.itacademy.entity.News;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NewsTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init(){
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void createReadTest(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        News news = new News();
        news.setText("This is first news");
        news.setName("First News!");
        news.setUser(session.find(User.class, 3L));
        Long id = (Long)session.save(news);
        News savedNews = session.find(News.class, id);
        assertEquals(news, savedNews);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish(){
        SESSION_FACTORY.close();
    }
}
