package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.NewsCommentDao;
import by.itacademy.entity.common.NewsComment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NewsCommentImpl extends BaseDaoImpl<NewsComment> implements NewsCommentDao {

    @Override
    public NewsComment changeText(NewsComment comment, String text) {
        comment.setText(text);
        return update(comment);
    }
}
