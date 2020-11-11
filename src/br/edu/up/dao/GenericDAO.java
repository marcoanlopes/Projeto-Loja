package br.edu.up.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public abstract class GenericDAO<T> implements DAO<T> {


    private Class<T> persistedClass;
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    protected GenericDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        persistedClass = (Class<T>) pt.getActualTypeArguments()[0];
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("electronic_store");
        entityManager = emf.createEntityManager();
    }

    public T create(T entity) {
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        entityManager.flush();
        t.commit();
        return entity;
    }

    public void delete(Integer id) {
        T entidade = getById(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T mergedEntity = entityManager.merge(entidade);
        entityManager.remove(mergedEntity);
        entityManager.flush();
        tx.commit();
    }

    public List<T> getAll() {
        String query = "select l from " + persistedClass.getName() + " l";
        return entityManager.createQuery(query, persistedClass).getResultList();
    }

    public T update(T entity) {
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.merge(entity);
        entityManager.flush();
        t.commit();
        return entity;
    }

    public T getById(Integer id) {
        return entityManager.find(persistedClass, id);
    }



}
