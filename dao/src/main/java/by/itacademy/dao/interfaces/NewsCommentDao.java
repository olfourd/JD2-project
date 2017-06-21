package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.NewsComment;

public interface NewsCommentDao extends BaseDao<NewsComment>{
    NewsComment changeText(NewsComment comment, String text);
}
