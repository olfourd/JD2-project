package by.itacademy.dao.classes;

import by.itacademy.dao.interfaces.UserDao;
import by.itacademy.entity.common.*;
import by.itacademy.entity.other.Address;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User changePicture(User model, String src) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        model.setSrcAvatar(src);
        update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public User changeNickName(User model, String nickName) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        model.setNickName(nickName);
        update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public User changePassword(User model, String password) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        model.setPassword(password);
        update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public User changeName(User model, String name) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        model.setName(name);
        update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public User changeCountry(User model, String country) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Address address = model.getAddress();
        address.setCountry(country);
        model.setAddress(address);
        update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public User changeCity(User model, String city) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Address address = model.getAddress();
        address.setCity(city);
        model.setAddress(address);
        update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public List<Topic> getCreatedTopicsById(Long primaryKey) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        QTopic topic = new QTopic("myTopic");
        JPAQuery<Topic> query = new JPAQuery<>(session);
        query.select(topic).from(topic).where(topic.user.id.eq(primaryKey));
        List<Topic> topics = query.fetchResults().getResults();

        transaction.commit();
        session.close();
        return topics;
    }

    //TODO: реализовать
    @Override
    public List<RoleOfUser> getAllRolles(Long primaryKey) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        QRoleOfUser role = new QRoleOfUser("myRole");
        JPAQuery<RoleOfUser> query = new JPAQuery<>(session);

        transaction.commit();
        session.close();
        return null;
    }

    //TODO: спросить как реализовать. возможно ли в данном построении БД
    @Override
    public List<Topic> getAllTopicsWhereUserTakePartInById(Long primaryKey) {
        return null;
    }
}
