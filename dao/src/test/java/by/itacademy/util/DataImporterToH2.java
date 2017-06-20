package by.itacademy.util;

import by.itacademy.entity.common.*;
import by.itacademy.entity.other.Address;
import by.itacademy.entity.other.HeroRole;
import by.itacademy.entity.other.KeyAbility;
import by.itacademy.entity.other.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class DataImporterToH2 {

    public void importTestData(Session session) {

        User userQwerty = saveUser(session, "Qwerty", "Qwerty", "AmazingQwerty");
        User userOlfourd = saveUser(session, "Olfourd", "Qwerty", "AmazingOlfourd");
        User userDeGriz = saveUser(session, "DeGriz", "Qwerty", "AmazingDeGriz");

        Hero alistar = saveHero(session, "Alistar", HeroRole.TANK);
        saveAbility(session, "Triumphant Roar", KeyAbility.PASSIVE, alistar);
        saveAbility(session, "Pulverize", KeyAbility.Q, alistar);
        saveAbility(session, "Headbutt", KeyAbility.W, alistar);
        saveAbility(session, "Trample", KeyAbility.W, alistar);
        saveAbility(session, "Unbreakable Will", KeyAbility.R, alistar);
        HeroTopic heroTopic = saveHeroTopic(session, "1st topic Alistar",
                "Hello from first topic Alistar", userQwerty, alistar);
        saveHeroTopic(session, "2nd topic Alistar", "Hello from second topic Alistar",
                userQwerty, alistar);
        saveHeroTopicComment(session, "Hi all, I'm first", userQwerty, heroTopic);
        saveHeroTopicComment(session, "second =(", userQwerty, heroTopic);

        Hero braum = saveHero(session, "Braum", HeroRole.SUPPORT);
        saveAbility(session, "Concussive Blows", KeyAbility.PASSIVE, braum);
        saveAbility(session, "Winter's Bite", KeyAbility.Q, braum);
        saveAbility(session, "Stand Behind Me", KeyAbility.W, braum);
        saveAbility(session, "Unbreakable", KeyAbility.E, braum);
        saveAbility(session, "Glacial Fissure", KeyAbility.R, braum);

        News news = saveNews(session, "This is the first News!", "hi", userOlfourd);
        saveNewsCommentTest(session, "hello from test", userOlfourd, news);
        saveNewsCommentTest(session, "hi all", userOlfourd, news);

        ForumTopicGlobal topicGlobal = saveGlobalTopic(session, "global topic");
        ForumTopicSimple topicSimple = saveSimpleTopic(session, "simple topic",
                "what is it?", userDeGriz, topicGlobal);
        saveForumPost(session, "this is comment", userDeGriz, topicSimple);
        saveForumPost(session, "qwerty", userDeGriz, topicSimple);

    }

    private ForumPost saveForumPost(Session session, String text, User user, ForumTopicSimple topic) {
        ForumPost forumPost = new ForumPost(text, user, topic);
        session.save(forumPost);
        return forumPost;
    }

    private ForumTopicSimple saveSimpleTopic(Session session, String name, String text, User user,
                                             ForumTopicGlobal topicGlobal) {
        ForumTopicSimple topicSimple = new ForumTopicSimple(name, text, user, topicGlobal);
        session.save(topicSimple);
        return topicSimple;
    }

    private ForumTopicGlobal saveGlobalTopic(Session session, String name) {
        ForumTopicGlobal topicGlobal = new ForumTopicGlobal(name);
        session.save(topicGlobal);
        return topicGlobal;
    }

    private NewsComment saveNewsCommentTest(Session session, String text, User user, News news) {
        NewsComment comment = new NewsComment(text, user, news);
        session.save(comment);
        return comment;
    }

    private HeroTopicMessage saveHeroTopicComment(Session session, String text, User user, HeroTopic heroTopic) {
        HeroTopicMessage comment = new HeroTopicMessage(text, user, heroTopic);
        session.save(comment);
        return comment;
    }

    private News saveNews(Session session, String name, String text, User user) {
        News news = new News(name, text, user);
        session.save(news);
        return news;
    }

    private HeroTopic saveHeroTopic(Session session, String name, String text, User user, Hero hero) {
        HeroTopic heroTopic = new HeroTopic(name, text, user, hero);
        session.save(heroTopic);
        return heroTopic;
    }

    private User saveUser(Session session, String login, String password, String nickName) {
        User user = new User(login, password, nickName);
        List<RoleOfUser> roles = new ArrayList<>(4);
        RoleOfUser roleUser = new RoleOfUser();
        roleUser.setRole(UserRole.USER);
        roles.add(roleUser);
        roleUser.setRole(UserRole.ADMIN);
        roles.add(roleUser);
        user.setRoleOfUser(roles);
        user.setAddress(new Address("Belarus", "Minsk"));
        session.save(user);
        return user;
    }

    private Hero saveHero(Session session, String name, HeroRole heroRole) {
        Hero hero = new Hero(name, heroRole);
        session.save(hero);
        return hero;
    }

    private HeroAbility saveAbility(Session session, String name, KeyAbility keyAbility, Hero hero) {
        HeroAbility heroAbility = new HeroAbility(name, keyAbility, hero);
        session.save(heroAbility);
        return heroAbility;
    }

    public void deleteAllDateFromDatabase(SessionFactory sessionFactory){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.createQuery("delete ForumPost");
        session.createQuery("delete ForumTopicSimple ");
        session.createQuery("delete ForumTopicGlobal ");
        session.createQuery("delete NewsComment ");
        session.createQuery("delete News ");
        session.createQuery("delete HeroAbility ");
        session.createQuery("delete HeroTopicMessage ");
        session.createQuery("delete HeroTopic ");
        session.createQuery("delete Hero ");
        session.createQuery("delete User ");



    }
}
