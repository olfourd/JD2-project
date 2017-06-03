package by.itacademy.dao.entityTests;

import by.itacademy.entity.Hero;
import by.itacademy.entity.HeroRoleEnum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveReadTest() throws Exception {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hero hero = new Hero();

        hero.setName("Shai");
        hero.setRole(HeroRoleEnum.SHOOTER);
        Long id = (Long) session.save(hero);
        Hero savedHero = session.find(Hero.class, id);
        assertEquals(hero, savedHero);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
