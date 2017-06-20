package by.itacademy.entity.common;

import by.itacademy.entity.common.Message;
import by.itacademy.entity.common.News;
import by.itacademy.entity.common.User;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "messages_from_news")
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
@ToString(callSuper = true, exclude = {"news"})
public class NewsComment extends Message {

    public NewsComment(String text, User user, News news) {
        super(text, user);
        this.news = news;
    }

    @ManyToOne
    @JoinColumn(name = "NEWS_ID")
    @Getter
    @Setter
    private News news;

    @Getter
    @Setter
    @Column(name = "likes")
    private long likeFromOthersUsers;
}
