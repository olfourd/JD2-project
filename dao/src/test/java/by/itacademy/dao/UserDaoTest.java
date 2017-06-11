package by.itacademy.dao;

import by.itacademy.dao.util.AllDataImporterForTests;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class UserDaoTest {

    private SessionFactory sessionFactory;

    @Before
    public void init() throws Exception {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        AllDataImporterForTests.getInstance().importTestData(sessionFactory);
    }

    @Test
    public void readById(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        User userFromDao = UserDao.getInstance().readById(1L);
        User user = session.find(User.class, 1L);



        assertEquals(user, userFromDao);

        transaction.commit();
        session.close();
    }
    @Test
    public void createUser() throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        transaction.commit();
        session.close();
    }

    @After
    public void finish() throws Exception {
        sessionFactory.close();
    }
}

