package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "messages_from_topic_hero")
@ToString(callSuper = true)
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
public class HeroTopicMessage extends Message{

    public HeroTopicMessage(String text, User user, HeroTopic topic) {
        super(text, user);
        this.topic = topic;
    }

    @Getter
    @Setter
    @Column(name = "likes")
    private long likeFromOthersUsers;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "TOPICS_HEROES_ID")
    private HeroTopic topic;
}
