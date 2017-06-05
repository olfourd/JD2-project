package by.itacademy.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "simple_forum_topic")
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
public class ForumTopicSimple extends Topic{

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "GLOBAL_FORUM_TOPIC_ID")
    private ForumTopicGlobal theme;

    @Getter
    @Setter
    @OneToMany(mappedBy = "forumTopic")
    private List<ForumPost> containedPosts = new ArrayList<>();
}
