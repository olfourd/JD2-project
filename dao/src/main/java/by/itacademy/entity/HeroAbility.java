package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ability")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HeroAbility extends BaseEntity{

    public HeroAbility(String name, KeyAbility keyAbility, Hero hero) {
        this.name = name;
        this.keyAbility = keyAbility;
        this.hero = hero;
    }

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "key_ability")
    private KeyAbility keyAbility;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "HERO_ID", nullable = false)
    private Hero hero;

    @Getter
    @Setter
    @Column(name = "pass_to_video")
    private String passToVideo;

}
