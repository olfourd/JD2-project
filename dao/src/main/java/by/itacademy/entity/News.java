package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
@ToString(callSuper = true, exclude = {"containedComments"})
public class News extends Topic{

    public News(String name, String text, User user) {
        super(name, text, user);
    }

    @Getter
    @Setter
    @Column(name = "pass_to_picture")
    private String srcPicture;

    @OneToMany(mappedBy = "news")
    private List<NewsComment> containedComments = new ArrayList<>();
}
