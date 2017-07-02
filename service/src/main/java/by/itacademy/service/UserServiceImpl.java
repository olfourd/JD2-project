package by.itacademy.service;

import by.itacademy.dao.RoleDaoImpl;
import by.itacademy.dao.UserDaoImpl;
import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.entity.other.UserRole;
import by.itacademy.service.common.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, UserDaoImpl> implements UserService, UserDetailsService {

    private final RoleDaoImpl roleDao;
    private final UserDaoImpl userDao;

    @Autowired
    public UserServiceImpl(RoleDaoImpl roleDao, UserDaoImpl userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    @Override
    public User create(User entity) {
        entity.setRoleOfUser(Arrays.asList(roleDao.getUser()));
        return super.create(entity);
    }

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDB = userDao.getByLogin(username);
        if (userFromDB == null) {
            throw new UsernameNotFoundException("User with name " + username + " not found");
        }
        return new org.springframework
                .security
                .core
                .userdetails
                .User(userFromDB.getName(), userFromDB.getPassword(), getUserAuthorities(userFromDB));
    }

    private List<GrantedAuthority> getUserAuthorities(User user) {
        return user.getRoleOfUser()
                .stream()
                .map(roleOfUser -> new SimpleGrantedAuthority(roleOfUser.getRole().name()))
                .collect(Collectors.toList());

    }
}
