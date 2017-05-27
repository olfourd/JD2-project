package by.itacademy.entity;

import lombok.*;

import javax.persistence.Id;

/**
 * Created by цифра on 22.05.2017.
 */


public class Ability {
    @Id
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;
    private String key;
    private Hero hero;
    private String passToVideo;

}
