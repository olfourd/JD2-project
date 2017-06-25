package by.itacademy.service;

import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.service.common.BaseService;

import java.util.List;

public interface UserService extends BaseService<User> {
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
