package by.itacademy.entity.common;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "messages_from_topic_hero")
@ToString(callSuper = true)
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "MESSAGE_ID")
@EqualsAndHashCode(callSuper = true)

public class HeroTopicMessage extends Message {

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
