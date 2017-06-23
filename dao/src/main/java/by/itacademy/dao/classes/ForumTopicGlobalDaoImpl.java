package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.ForumTopicGlobalDao;
import by.itacademy.entity.common.ForumTopicGlobal;
import by.itacademy.entity.common.ForumTopicSimple;
import by.itacademy.entity.common.QForumTopicSimple;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ForumTopicGlobalDaoImpl extends BaseDaoImpl<ForumTopicGlobal> implements ForumTopicGlobalDao {
    @Override
    public ForumTopicGlobal getByName(String name) {
        return getSessionFactory().
                getCurrentSession()
                .createQuery("from ForumTopicGlobal where name=:topicName", ForumTopicGlobal.class)
                .setParameter("topicName", name)
                .getSingleResult();
    }

    @Override
    public ForumTopicGlobal changeName(ForumTopicGlobal topic, String name) {
        topic.setName(name);
        return update(topic);
    }

    @Override
    public List<ForumTopicSimple> getAllSimpleTopicsById(Long id) {
        QForumTopicSimple topic = new QForumTopicSimple("topic");
        JPAQuery<ForumTopicSimple> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        List<ForumTopicSimple> results = query.select(topic).from(topic).where(topic.theme.id.eq(id)).fetchResults().getResults();
        return results;
    }
}
