package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.ForumTopicGlobalDao;
import by.itacademy.entity.common.ForumTopicGlobal;
import by.itacademy.entity.common.ForumTopicSimple;
import by.itacademy.util.DataImporterToH2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ForumTopicGlobalDaoTest extends BaseDaoTest {

    @Autowired
    private ForumTopicGlobalDao topicGlobalDao;
    @Autowired
    private DataImporterToH2 importerToH2;

    @Before
    public void init() {
        importerToH2.importTestData(topicGlobalDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void getByName() {
        String name = "global topic";
        ForumTopicGlobal globalTopic = topicGlobalDao.getByName(name);
        assertEquals(globalTopic.getName(), name);
    }

    @Test
    public void changeName() {
        ForumTopicGlobal topic = topicGlobalDao.getByName("global topic");
        String newName = "QWERTY";
        topic.setName(newName);
        ForumTopicGlobal updatedTopic = topicGlobalDao.changeName(topic, newName);
        assertEquals(updatedTopic.getName(), newName);
    }

    @Test
    public void getAllSimpleTopicsById() {
        ForumTopicGlobal topic = topicGlobalDao.getByName("global topic");
        List<ForumTopicSimple> allSimpleTopics = topicGlobalDao.getAllSimpleTopicsById(topic.getId());
        assertThat(allSimpleTopics, hasSize(1));
        List<String> names = allSimpleTopics.stream().map(ForumTopicSimple::getName).collect(toList());
        assertTrue(names.contains("simple topic"));
    }

}