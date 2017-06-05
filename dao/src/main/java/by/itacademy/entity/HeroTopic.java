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
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
public class HeroTopic extends Topic {

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
