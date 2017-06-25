package by.itacademy.service;


import by.itacademy.dao.NewsCommentDaoImpl;
import by.itacademy.entity.NewsComment;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NewsCommentServiceImpl
        extends BaseServiceImpl<NewsComment, NewsCommentDaoImpl> implements NewsCommentService{
    @Override
    public NewsComment changeText(NewsComment comment, String text) {
        return getRepository().changeText(comment, text);
    }
}
