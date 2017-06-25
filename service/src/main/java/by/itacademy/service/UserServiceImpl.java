package by.itacademy.service;

import by.itacademy.dao.UserDaoImpl;
import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, UserDaoImpl> implements UserService {

    @Override
    public User changePicture(User model, String src) {
        return getRepository().changePicture(model, src);
    }

    @Override
    public User changeNickName(User model, String nickName) {
        return getRepository().changeNickName(model, nickName);
    }

    @Override
    public User changePassword(User model, String password) {
        return getRepository().changePassword(model, password);
    }

    @Override
    public User changeName(User model, String name) {
        return getRepository().changeName(model, name);
    }

    @Override
    public User changeCountry(User model, String country) {
        return getRepository().changeCountry(model, country);
    }

    @Override
    public User changeCity(User model, String city) {
        return getRepository().changeCity(model, city);
    }

    @Override
    public List<Topic> getCreatedTopicsById(Long primaryKey) {
        return getRepository().getCreatedTopicsById(primaryKey);
    }

    @Override
    public List<RoleOfUser> getAllRolles(Long primaryKey) {

        return getRepository().getById(primaryKey).getRoleOfUser();
    }

    @Override
    public User getByLogin(String login) {
        return getRepository().getByLogin(login);
    }
}
