package by.itacademy.dao.classes;


import by.itacademy.dao.interfaces.BaseDao;
import by.itacademy.entity.common.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.util.List;


public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    protected BaseDaoImpl() {
        this.entityClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDaoImpl.class);
    }

    public T getById(Long primaryKey) {
        return sessionFactory.getCurrentSession().find(entityClass, primaryKey);
    }

    @Override
    public T save(T model) {
        sessionFactory.getCurrentSession().save(model);
        return model;
    }

    @Override
    public T update(T model) {
        sessionFactory.getCurrentSession().update(model);
        return model;
    }

    @Override
    public boolean delete(T model) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(model);
        boolean result = false;
        if (!session.contains(model)) {
            result = true;
        }
        return result;
    }

    public List<T> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}