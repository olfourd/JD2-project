package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics_heroes")
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"hero", "containedMessages"})
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
public class HeroTopic extends Topic {

    public HeroTopic(String name, String text, User user, Hero hero) {
        super(name, text, user);
        this.hero = hero;
    }

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "HERO_ID", nullable = false)
    private Hero hero;

    @Getter
    @Setter
    @OneToMany(mappedBy = "topic")
    private List<HeroTopicMessage> containedMessages = new ArrayList<>();
}
