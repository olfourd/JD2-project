package by.itacademy.service.common;

import by.itacademy.dao.common.BaseDaoImpl;
import by.itacademy.entity.common.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity, K extends BaseDaoImpl> implements BaseService<T> {

    private K repository;

    protected K getRepository() {
        return repository;
    }

    @Autowired
    public void setRepository(K repository) {
        this.repository = repository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T create(T entity) {
        return (T) repository.save(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T getById(Long primaryKey) {
        return (T) repository.getById(primaryKey);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T update(T entity) {
        return (T) repository.update(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean delete(T entity) {
        return repository.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return repository.getAll();
    }
}
