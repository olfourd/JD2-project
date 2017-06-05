package by.itacademy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "forum_post")
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
public class ForumPost extends Message{

    @Getter
    @Setter
    @Column(name = "likes")
    private long likes;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "SIMPLE_FORUM_TOPIC_ID")
    private ForumTopicSimple forumTopic;
}
