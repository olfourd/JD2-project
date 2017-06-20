package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.NewsDao;
import by.itacademy.entity.common.News;
import by.itacademy.entity.common.NewsComment;
import by.itacademy.util.DataImporterToH2;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
@Transactional
public class NewsDaoTest {

    @Autowired
    private NewsDao newsDao;
    @Autowired
    private DataImporterToH2 dataImport;

    @Before
    public void init() throws Exception {
        dataImport.importTestData(newsDao.getSessionFactory().getCurrentSession());
    }

    @Test
    public void changePicture() throws Exception {
        News news = newsDao.getById(3L);
        String srcPicture = "D:/";
        News updatedNews = newsDao.changePicture(news, srcPicture);
        assertEquals(updatedNews.getSrcPicture(), srcPicture);
    }

    @Test
    public void changeName() throws Exception {
        News news = newsDao.getById(3L);
        String name = "HELLO!";
        News updatedNews = newsDao.changeName(news, name);
        assertEquals(updatedNews.getName(), name);
    }

    @Test
    public void changeText() throws Exception {
        News news = newsDao.getById(3L);
        String Text = "Change text";
        News updatedNews = newsDao.changeText(news, Text);
        assertEquals(updatedNews.getText(), Text);
    }

    @Test
    public void getCommentsByNewsId() throws Exception {
        List<NewsComment> comments = newsDao.getCommentsByNewsId(3L);
        List<String> textOfComments = comments.stream().map(NewsComment::getText).collect(toList());
        assertThat(textOfComments, hasSize(2));
        assertThat(textOfComments, contains("hello from test", "hi all"));
    }

}