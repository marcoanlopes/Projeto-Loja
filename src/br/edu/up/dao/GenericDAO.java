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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("cadastro");
		entityManager = emf.createEntityManager();
	}

	public T save(T entidade) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.persist(entidade);
		entityManager.flush();
		t.commit();
		return entidade;
	}

	public void erase(Integer id) {
		T entidade = findById(id);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		T mergedEntity = entityManager.merge(entidade);
		entityManager.remove(mergedEntity);
		entityManager.flush();
		tx.commit();
	}

	public List<T> list() {
		String query = "select l from " + persistedClass.getName() + " l";
		return entityManager.createQuery(query, persistedClass).getResultList();
	}

	public T updateDAO(T entidade) {
		EntityTransaction t = entityManager.getTransaction();
		t.begin();
		entityManager.merge(entidade);
		entityManager.flush();
		t.commit();
		return entidade;
	}

	public T findById(Integer id) {
		return entityManager.find(persistedClass, id);
	}
	


}
	
