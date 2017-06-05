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

    @Getter
    @Setter
    @Column(name = "likes")
    private int likeFromOthersUsers;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "TOPICS_HEROES_ID")
    private HeroTopic topic;
}
