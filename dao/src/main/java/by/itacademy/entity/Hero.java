package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hero")
@NoArgsConstructor
public class Hero extends BaseEntity{

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "pass")
    private String passToPicture;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private HeroRole role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "hero")
    private List<HeroAbility> abilities = new ArrayList<>();


}
