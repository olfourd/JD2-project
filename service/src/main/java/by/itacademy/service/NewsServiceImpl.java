package by.itacademy.service;

import by.itacademy.dao.NewsDaoImpl;
import by.itacademy.entity.News;
import by.itacademy.entity.NewsComment;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsServiceImpl extends BaseServiceImpl<News, NewsDaoImpl> implements NewsService{
    @Override
    public News changePicture(News model, String src) {
        return getRepository().changePicture(model, src);
    }

    @Override
    public News changeName(News model, String name) {
        return getRepository().changeName(model, name);
    }

    @Override
    public News changeText(News model, String text) {
        return getRepository().changeText(model, text);
    }

    @Override
    public List<NewsComment> getCommentsByNewsId(Long primaryKey) {
        return getRepository().getCommentsByNewsId(primaryKey);
    }

    @Override
    public News getByName(String name) {
        return getRepository().getByName(name);
    }
}
