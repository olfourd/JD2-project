package by.itacademy.dao.classes;


import by.itacademy.dao.interfaces.BaseDao;
import by.itacademy.entity.common.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.core.GenericTypeResolver;

import java.util.List;


public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    private static SessionFactory SESSION_FACTORY =
            new Configuration().configure().buildSessionFactory();

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected BaseDaoImpl() {
        this.entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    public T getById(Long primaryKey) {
        Session session = SESSION_FACTORY.openSession();

        T result = session.find(entityClass, primaryKey);

        session.close();
        return result;
    }

    @Override
    public T save(T model) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public T update(T model) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(model);

        transaction.commit();
        session.close();
        return model;
    }

    @Override
    public boolean delete(T model) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(model);
        boolean result = false;
        if (!session.contains(model)) {
            result = true;
        }
        transaction.commit();
        session.close();
        return result;
    }

    public List<T> getAll() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        List<T> result = session.createQuery("from " + entityClass.getSimpleName(), entityClass).
                getResultList();

        transaction.commit();
        session.close();
        return result;
    }

    //TODO: изменить в дальнейшем
    public SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}