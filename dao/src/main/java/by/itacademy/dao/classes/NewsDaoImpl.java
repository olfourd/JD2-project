package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.NewsDao;
import by.itacademy.entity.common.News;
import by.itacademy.entity.common.NewsComment;
import by.itacademy.entity.common.QNewsComment;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao{

    @Override
    public News changePicture(News model, String src) {
        model.setSrcPicture(src);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public News changeName(News model, String name) {
        model.setName(name);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public News changeText(News model, String text) {
        model.setText(text);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public List<NewsComment> getCommentsByNewsId(Long primaryKey) {
        QNewsComment comment = new QNewsComment("comment");
        JPAQuery<NewsComment> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        List<NewsComment> results = query.select(comment)
                .from(comment)
                .where(comment.news.id.eq(primaryKey))
                .fetchResults()
                .getResults();

        return results;
    }

    @Override
    public News getByName(String name) {
        Session session = getSessionFactory().getCurrentSession();
        News news = session.createQuery("select n from News n where n.name=:newsName", News.class)
                .setParameter("newsName", name)
                .getResultList()
                .get(0);
        return news;
    }
}
