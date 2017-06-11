package by.itacademy.entity;


import by.itacademy.dao.util.AllDataImporterForTests;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EntityTests {
    private SessionFactory sessionFactory;

    @Before
    public void init() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        AllDataImporterForTests.getInstance().importTestData(sessionFactory);
    }

    @Test
    public void createReadUserTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User("qwerty", "qwerty", "qwerty");
        Long id = (Long) session.save(user);
        User savedUser = session.find(User.class, id);

        assertEquals(user, savedUser);

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadHeroTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Hero hero = new Hero();
        hero.setName("Shai");
        hero.setRole(HeroRole.SHOOTER);
        Long id = (Long) session.save(hero);
        Hero savedHero = session.find(Hero.class, id);
        assertEquals(hero, savedHero);

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadHeroAbilityTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        Hero hero = session.find(Hero.class, 1L);
        HeroAbility ability = new HeroAbility();
        ability.setName("Hello");
        ability.setKeyAbility(KeyAbility.PASSIVE);
        ability.setHero(hero);
        Long id = (Long) session.save(ability);
        assertEquals(ability, session.find(HeroAbility.class, id));

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadHeroTopicTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        HeroTopic topic = new HeroTopic();
        topic.setUser(session.find(User.class, 1L));
        topic.setName("Hello from test");
        topic.setText("HI!");
        topic.setHero(session.find(Hero.class, 1L));
        Long id = (Long) session.save(topic);
        HeroTopic savedTopicHero = session.find(HeroTopic.class, id);
        assertEquals(topic, savedTopicHero);

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadHeroTopicMessageTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        HeroTopicMessage message = new HeroTopicMessage();
        User user = session.find(User.class, 1L);
        message.setUser(user);
        HeroTopic topic = session.find(HeroTopic.class, 1L);
        message.setTopic(topic);
        message.setText("I'm first");
        Long id = (Long) session.save(message);
        HeroTopicMessage savedMessage = session.find(HeroTopicMessage.class, id);
        assertEquals(message, savedMessage);

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadNewsTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        News news = new News();
        news.setText("This is first news");
        news.setName("First News!");
        news.setUser(session.find(User.class, 2L));
        Long id = (Long) session.save(news);
        News savedNews = session.find(News.class, id);
        assertEquals(news, savedNews);

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadNewsCommentTest() {
        Session session = sessionFactory.openSession();
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

    @Test
    public void createReadGlobalTopicTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ForumTopicGlobal topicGlobal = new ForumTopicGlobal("1ST GLOBAL TOPIC");
        Long idGlobalTopic = (Long) session.save(topicGlobal);
        ForumTopicGlobal savedGlobalTopic = session.find(ForumTopicGlobal.class, idGlobalTopic);

        assertEquals(topicGlobal, savedGlobalTopic);
        transaction.commit();
        session.close();
    }

    @Test
    public void createReadSimpleTopicTest() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ForumTopicGlobal topicGlobal = session.find(ForumTopicGlobal.class, 1L);
        User user = session.find(User.class, 1L);
        ForumTopicSimple topicSimple = new ForumTopicSimple("qwerty", "qwerty", user, topicGlobal);
        Long id = (Long) session.save(topicSimple);
        ForumTopicSimple savedSimpleTopic = session.find(ForumTopicSimple.class, id);
        assertEquals(topicSimple, savedSimpleTopic);

        transaction.commit();
        session.close();
    }

    @Test
    public void createReadForumPostTest(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        User user = session.find(User.class, 1L);
        ForumTopicSimple topic = session.find(ForumTopicSimple.class, 1L);
        ForumPost forumPost = new ForumPost("forum post", user, topic);
        Long id = (Long) session.save(forumPost);
        ForumPost savedPost = session.find(ForumPost.class, id);
        assertEquals(savedPost, forumPost);

        transaction.commit();
        session.close();
    }

    @After
    public void finish() {
        sessionFactory.close();
    }
}
