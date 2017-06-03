package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@ToString
public class User extends BaseEntity {

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
    private String srcPicture;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private UserRole role;
}
