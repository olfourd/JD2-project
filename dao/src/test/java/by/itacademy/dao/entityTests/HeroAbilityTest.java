package by.itacademy.dao.entityTests;

import by.itacademy.entity.HeroAbility;
import by.itacademy.entity.Hero;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeroAbilityTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init() {
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveReadTest() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        Hero hero = session.find(Hero.class, 135L);
        HeroAbility ability = new HeroAbility();
        ability.setName("Hello");
        ability.setKeyAbility("passive");
        ability.setHero(hero);
        Long id = (Long) session.save(ability);
        assertEquals(ability, session.find(HeroAbility.class, id));

        transaction.commit();
        session.close();
    }


    @AfterClass
    public static void finish() {
        SESSION_FACTORY.close();
    }
}
