package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "messages_from_news")
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
public class NewsComment extends Message{

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
