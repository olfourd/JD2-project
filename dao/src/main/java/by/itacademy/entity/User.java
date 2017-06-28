package by.itacademy.entity;

import by.itacademy.entity.common.BaseEntity;
import by.itacademy.entity.other.Address;
import by.itacademy.entity.other.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class User extends BaseEntity {

    public User(String login, String password, String nickName) {
        this.login = login;
        this.password = password;
        this.nickName = nickName;
    }

    @Column(name = "login")
    @Getter
    @Setter
    private String login;

    @Column(name = "password")
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

    @Getter
    @Setter
    @Embedded
    private Address address;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Topic> createdTopics = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();

    @Getter
    @Setter
    @ManyToMany(mappedBy = "users")
    private List<RoleOfUser> roleOfUser = new ArrayList<>(4);
}
