package by.itacademy.dao;


import by.itacademy.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public abstract class GenericDao<T extends BaseEntity> {

    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T readById(Long primaryKey) {
        Session session = SESSION_FACTORY.openSession();

        T result = session.find(entityClass, primaryKey);

        session.close();
        return result;
    }

    public T create(T entityObject) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(entityObject);

        transaction.commit();
        session.close();
        return entityObject;
    }

    public T update(long primeryKey, T entinyObject) {
//        Session session = SESSION_FACTORY.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        T updatedEntity = session.find(entityClass, id);
//
//
//        transaction.commit();
//        session.close();
        return entinyObject;
    }

    public void delete(T object) {
        boolean result = false;
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(object);

        transaction.commit();
        session.close();
    }

    public List<T> getAll() {
        return null;
    }
}