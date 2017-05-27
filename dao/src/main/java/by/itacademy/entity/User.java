package by.itacademy.entity;

import lombok.*;
import javax.persistence.*;

/**
 * Created by цифра on 22.05.2017.
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private RoleOfUsers role;

    @Column(name = "login")
    @Getter
    @Setter
    private String login;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column (name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "second_name")
    @Getter
    @Setter
    private String secondName;

    @Column(name = "mail")
    @Getter
    @Setter
    private String mail;

    @Column(name = "pass_to_picture")
    @Getter
    @Setter
    private String srcPicture;
}
