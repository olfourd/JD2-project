package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.ForumPostDao;
import by.itacademy.entity.common.ForumPost;
import by.itacademy.util.DataImporterToH2;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ForumPostDaoTest extends BaseDaoTest {

    @Autowired
    private ForumPostDao forumPostDao;
    @Autowired
    private DataImporterToH2 importerToH2;

    @Before
    public void init() {
        importerToH2.importTestData(forumPostDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void changeText() throws Exception {
        ForumPost post = forumPostDao.getAll().get(0);
        String text = "ASDFGH";
        ForumPost changedPost = forumPostDao.changeText(post, text);
        assertEquals(changedPost.getText(), text);
    }

}