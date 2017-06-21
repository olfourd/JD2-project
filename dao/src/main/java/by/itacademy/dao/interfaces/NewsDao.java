package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.News;
import by.itacademy.entity.common.NewsComment;

import java.util.List;

public interface NewsDao extends BaseDao<News> {
    News changePicture(News model, String src);

    News changeName(News model, String name);

    News changeText(News model, String text);

    List<NewsComment> getCommentsByNewsId(Long primaryKey);

    News getByName(String name);
}
