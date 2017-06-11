package by.itacademy.dao;

import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;

import java.util.List;
import java.util.Set;

public final class UserDao extends GenericDao<User> {

    private static UserDao INSTANCE;

    private UserDao() {
        super(User.class);
    }

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

    public User changePassword(long idChangingUser, String newPassword) {
        return null;
    }

    public User changeName(long idChangingUser, String name) {
        return null;
    }

    public User changeNickName(long idChangingUser, String nickName) {
        return null;
    }

    public User changeMail(long idChangingUser, String mail) {
        return null;
    }

//    public User changeAvatar(String passToAvatar) {
//        return null;
//    }

    public List<Topic> getAllCreatedTopics(long userId) {
        return null;
    }

    public Set<RoleOfUser> getAllRolesById(long userId) {
        return null;
    }

}
