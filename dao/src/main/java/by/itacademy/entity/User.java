package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
@ToString(exclude = {"createdTopics", "participationInTopics"})
public class User extends BaseEntity {

    public User(String login, String password, String name, String nickName, UserRole role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.role = role;
    }

    @Column(name = "login", nullable = false)
    @Getter
    @Setter
    private String login;

    @Column(name = "password", nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "nick_name")
    @Getter
    @Setter
    private String nickName;

    @Column(name = "mail")
    @Getter
    @Setter
    private String mail;

    @Column(name = "pass_to_picture")
    @Getter
    @Setter
    private String srcAvatar;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private UserRole role;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Topic> createdTopics = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Message> participationInTopics = new ArrayList<>();
}
