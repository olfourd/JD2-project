package by.itacademy.dao;

import by.itacademy.dao.common.BaseDao;
import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;

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

    User getByLogin(String login);

}
