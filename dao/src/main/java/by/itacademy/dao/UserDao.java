package by.itacademy.dao;

import by.itacademy.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDao {

    public User createUser(String login, String password, String name, String secondName,
                           String mail) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User(login, password, name, secondName, mail);
        session.save(user);
        System.out.println(user.getId());
        return user;
    }

    public User readUserById(long id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    public User updateUserById(User user) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User foundedUser = session.find(User.class, user.getId());
        foundedUser.setLogin(user.getLogin());
        foundedUser.setPassword(user.getPassword());
        foundedUser.setName(user.getName());
        foundedUser.setSecondName(user.getSecondName());
        foundedUser.setMail(user.getMail());
        return foundedUser;
    }
}
