package by.itacademy.dao.util;

import by.itacademy.entity.*;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

@NoArgsConstructor
public final class AllDataImporterForTests {
    private static AllDataImporterForTests INSTANCE;

    public static AllDataImporterForTests getInstance() {
        if (INSTANCE == null) {
            synchronized (AllDataImporterForTests.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AllDataImporterForTests();
                }
            }
        }
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();

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
                userOlfourd, alistar);
        saveHeroTopicComment(session, "Hi all, I'm first", userDeGriz, heroTopic);
        saveHeroTopicComment(session, "second =(", userQwerty, heroTopic);

        Hero braum = saveHero(session, "Braum", HeroRole.SUPPORT);
        saveAbility(session, "Concussive Blows", KeyAbility.PASSIVE, braum);
        saveAbility(session, "Winter's Bite", KeyAbility.Q, braum);
        saveAbility(session, "Stand Behind Me", KeyAbility.W, braum);
        saveAbility(session, "Unbreakable", KeyAbility.E, braum);
        saveAbility(session, "Glacial Fissure", KeyAbility.R, braum);

        News news = saveNews(session, "This is the first News!", "hi", userOlfourd);
        saveNewsCommentTest(session, "hello from test", userQwerty, news);
        saveNewsCommentTest(session, "hi all", userQwerty, news);

        ForumTopicGlobal topicGlobal = saveGlobalTopic(session, "global topic");
        ForumTopicSimple topicSimple = saveSimpleTopic(session, "simple topic",
                "what is it?", userOlfourd, topicGlobal);
        saveForumPost(session, "this is comment", userOlfourd, topicSimple);
        saveForumPost(session, "qwerty", userQwerty, topicSimple);

        session.close();
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
        Set<RoleOfUser> roles = new HashSet<>(4);
        RoleOfUser roleOfUser = new RoleOfUser();
        roleOfUser.setRole(UserRole.USER);
        roles.add(roleOfUser);
        user.setRoleOfUser(roles);
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

}
