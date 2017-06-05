package by.itacademy.dao.entityTests;

import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class NewsCommentTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void createReadTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        NewsComment comment = new NewsComment();
        comment.setUser(session.find(User.class, 3L));
        comment.setText("I'm 1st!");
        comment.setNews(session.find(News.class, 4L));
        Long id = (Long) session.save(comment);
        NewsComment savedComment = session.find(NewsComment.class, id);
        assertEquals(comment, savedComment);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
