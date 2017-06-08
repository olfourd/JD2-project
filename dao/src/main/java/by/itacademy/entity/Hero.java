package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hero")
@NoArgsConstructor
@ToString(exclude = {"abilities", "topics"})
public class Hero extends BaseEntity{

    public Hero(String name, HeroRole role) {
        this.name = name;
        this.role = role;
    }

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(name = "pass")
    private String passToPicture;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private HeroRole role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "hero")
    private List<HeroAbility> abilities = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "hero")
    private List<HeroTopic> topics = new ArrayList<>();

}
