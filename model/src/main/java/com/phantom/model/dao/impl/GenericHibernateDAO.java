package com.phantom.model.dao.impl;

import com.phantom.model.dao.GenericDAO;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

public class GenericHibernateDAO<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {


    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings("unchecked")
    public T findById(ID id) {
        return (T) this.getHibernateTemplate().get(getPersistentClass().getName(), id);
    }

    public T saveOrUpdate(T entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
        return entity;
    }

    public List<T> saveOrUpdateAll(List<T> entities) {
        if (!CollectionUtils.isEmpty(entities)) {
            for (T entity : entities) {
                this.getHibernateTemplate().save(entity);
            }
        }
        return entities;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return (List<T>) this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(getPersistentClass()));
    }

    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    public void delete(Collection<T> entities) {
        this.getHibernateTemplate().deleteAll(entities);
    }

    @SuppressWarnings("unchecked")
    public List<T> findByCriteria(DetachedCriteria criteria) {
        return (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public void merge(T entity) {
        this.getHibernateTemplate().merge(entity);
    }
}
