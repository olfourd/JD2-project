package by.itacademy.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    public User(String login, String password, String name, String secondName, String mail) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.mail = mail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

//    @Column(name = "role")
//    @Getter
//    @Setter
//    private RoleUser role;

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
