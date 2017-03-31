package com.oracle.hackathon.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import static com.oracle.hackathon.dao.DepotDBEntityManagerFactory.emf;

/**
 * Created by xinyuan.zhang on 3/30/17.
 */

public abstract class AbstractDao<T extends Serializable> implements Serializable {

    private final Class<T> clazz;
    protected  EntityManager em;

    public AbstractDao(Class<T> clazz) {
        this.em =emf.createEntityManager();
        this.clazz = clazz;
    }

    public T find(Object id) {
        return em.find(clazz, id);
    }

    public void persist(final T entity) {
        em.persist(entity);
    }

    public List<T> findAll() {
        final CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(clazz);
        criteriaQuery.select(criteriaQuery.from(clazz));
        return em.createQuery(criteriaQuery).getResultList();
    }

    /*public void deleteAll() {
        final CriteriaDelete<T> criteriaDelete = em.getCriteriaBuilder().createCriteriaDelete(clazz);
        criteriaDelete.from(clazz);
        em.createQuery(criteriaDelete).executeUpdate();
    }*/
}
