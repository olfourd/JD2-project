package by.itacademy.dao;

import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.entity.UserRole;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
public final class UserDao {

    private static UserDao INSTANCE;


    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    public User createUser(String login, String password, String nickName) {
        return null;
    }

    public User readUserById(Long id) {
        return null;
    }

    public User changePassword(String password) {
        return null;
    }

    public User changeName(String name) {
        return null;
    }

    public User changeNickName(String nickName) {
        return null;
    }

    public User changeMail(String mail) {
        return null;
    }

    public User changeAvatar(String passToAvatar) {
        return null;
    }

    public List<Topic> createdTopics() {
        return null;
    }

    public Set<RoleOfUser> readAllRolles(){
        return null;
    }

}
