package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ability")
public class Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "key_ability")
    private String keyAbility;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "hero", nullable = false)
    private Hero hero;

    @Getter
    @Setter
    @Column(name = "pass_to_video")
    private String passToVideo;

}
