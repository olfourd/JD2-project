package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@NoArgsConstructor
@ToString
public class RoleOfUser extends BaseEntity {

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    Set<User> users = new HashSet<>();
}
