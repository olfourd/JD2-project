package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "topic")
@NoArgsConstructor
public class Topic extends BaseEntity{

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "text", nullable = false)
    private String text;

    @Getter
    @Setter
    @Column(name = "date")
    private LocalDate dateOfCreation;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
