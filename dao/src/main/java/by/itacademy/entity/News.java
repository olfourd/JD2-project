package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "TOPIC_ID")
public class News extends Topic{

    @Getter
    @Setter
    @Column(name = "pass_to_picture")
    private String srcPicture;

    @OneToMany(mappedBy = "news")
    private List<NewsComment> containedComments = new ArrayList<>();
}
