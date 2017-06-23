package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.ForumPost;

public interface ForumPostDao extends BaseDao<ForumPost>{
    ForumPost changeText(ForumPost post, String text);
}
