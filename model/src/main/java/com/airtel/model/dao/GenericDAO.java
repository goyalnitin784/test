package com.airtel.model.dao;

import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

/**
 *
 *
 * @param <T>
 * @param <ID>
 */
public interface GenericDAO<T, ID extends Serializable> {

    /**
     * Get the entity by Id.
     */
    T findById(ID id);

    /**
     * Saves or Updates the entity of the {@link ParameterizedType} return it.
     *
     * @param entity
     * @return T
     */
    T saveOrUpdate(T entity);

    /**
     * Saves or Updates the a collection of entities of the {@link ParameterizedType} return it.
     *
     * @param
     * @return List<T> entities
     */
    List<T> saveOrUpdateAll(List<T> entities) ;

    void delete(T entity);

    void delete(Collection<T> entities);

    void merge(T entity);

    List<T> findAll();

    List<T> findByCriteria(DetachedCriteria criteria);

}

