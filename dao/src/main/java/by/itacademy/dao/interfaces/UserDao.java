package by.itacademy.dao.interfaces;

import by.itacademy.entity.common.RoleOfUser;
import by.itacademy.entity.common.Topic;
import by.itacademy.entity.common.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    User changePicture(User model, String src);

    User changeNickName(User model, String nickName);

    User changePassword(User model, String password);

    User changeName(User model, String name);

    User changeCountry(User model, String country);

    User changeCity(User model, String city);

    List<Topic> getCreatedTopicsById(Long primaryKey);

    List<RoleOfUser> getAllRolles(Long primaryKey);

    List<Topic> getAllTopicsWhereUserTakePartInById(Long primaryKey);
}
