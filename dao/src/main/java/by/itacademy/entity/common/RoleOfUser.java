package by.itacademy.entity.common;

import by.itacademy.entity.other.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    List<User> users = new ArrayList<>(4);
}
