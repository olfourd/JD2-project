package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.ForumPostDao;
import by.itacademy.entity.common.ForumPost;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ForumPostDaoIml extends BaseDaoImpl<ForumPost> implements ForumPostDao{
    @Override
    public ForumPost changeText(ForumPost post, String text) {
        post.setText(text);
        return update(post);
    }
}
