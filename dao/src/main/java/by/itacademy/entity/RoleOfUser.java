package by.itacademy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
public class RoleOfUser extends BaseEntity {

    public RoleOfUser(UserRole role) {
        this.role = role;
    }

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
