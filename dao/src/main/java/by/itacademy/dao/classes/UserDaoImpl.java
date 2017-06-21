package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.UserDao;
import by.itacademy.entity.common.*;
import by.itacademy.entity.other.Address;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User changePicture(User model, String src) {
        model.setSrcAvatar(src);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public User changeNickName(User model, String nickName) {
        model.setNickName(nickName);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public User changePassword(User model, String password) {
        model.setPassword(password);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public User changeName(User model, String name) {
        model.setName(name);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public User changeCountry(User model, String country) {
        Address address = model.getAddress();
        address.setCountry(country);
        model.setAddress(address);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public User changeCity(User model, String city) {
        Address address = model.getAddress();
        address.setCity(city);
        model.setAddress(address);
        getSessionFactory().getCurrentSession().update(model);
        return model;
    }

    @Override
    public List<Topic> getCreatedTopicsById(Long primaryKey) {
        QTopic topic = new QTopic("myTopic");
        JPAQuery<Topic> query = new JPAQuery<>(getSessionFactory().getCurrentSession());
        query.select(topic).from(topic).where(topic.user.id.eq(primaryKey));
        List<Topic> topics = query.fetchResults().getResults();
        return topics;
    }

    @Override
    public List<RoleOfUser> getAllRolles(Long primaryKey) {
        Session session = getSessionFactory().getCurrentSession();
        User user = session.find(User.class, primaryKey);
        List<RoleOfUser> roleOfUser = user.getRoleOfUser();
        return roleOfUser;
    }

    @Override
    public User getByLogin(String login) {
        Session session = getSessionFactory().getCurrentSession();
        User user = session.createQuery("select u from User u where u.login=:userLogin", User.class)
                .setParameter("userLogin", login)
                .getResultList()
                .get(0);
        return user;
    }
}
