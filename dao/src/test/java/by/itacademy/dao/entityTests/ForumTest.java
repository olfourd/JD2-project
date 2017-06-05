package by.itacademy.dao.entityTests;

import by.itacademy.entity.ForumPost;
import by.itacademy.entity.ForumTopicGlobal;
import by.itacademy.entity.ForumTopicSimple;
import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ForumTest {
    private static SessionFactory SESSION_FACTORY;

    @BeforeClass
    public static void init(){
        SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void saveReadAllForumEntities(){
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        ForumTopicGlobal topicGlobal = new ForumTopicGlobal();
        topicGlobal.setName("1ST GLOBAL TOPIC");
        Long idGlobalTopic = (Long) session.save(topicGlobal);

        ForumTopicSimple topicSimple = new ForumTopicSimple();
        topicSimple.setTheme(topicGlobal);
        topicSimple.setName("qwerty");
        topicSimple.setText("qwerty");
        topicSimple.setUser(session.find(User.class, 3L));
        session.save(topicSimple);

        ForumPost forumPost = new ForumPost();
        forumPost.setForumTopic(topicSimple);
        forumPost.setText("hi");
        forumPost.setUser(session.find(User.class, 3L));
        session.save(forumPost);

        List<ForumPost> postList = new ArrayList<>();
        postList.add(forumPost);
        topicSimple.setContainedPosts(postList);
        List<ForumTopicSimple> simpleList = new ArrayList<>();
        simpleList.add(topicSimple);
        topicGlobal.setContainedTopics(simpleList);
        ForumTopicGlobal savedGlobalTopic = session.find(ForumTopicGlobal.class, idGlobalTopic);

        assertEquals(topicGlobal, savedGlobalTopic);
        transaction.commit();
        session.close();
    }

    @AfterClass
    public static void finish(){
        SESSION_FACTORY.close();
    }
}
