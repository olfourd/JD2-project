package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table
public class HeroMessage extends BaseEntity {

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private LocalDate date;



}
