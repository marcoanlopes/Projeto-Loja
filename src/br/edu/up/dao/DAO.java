package br.edu.up.dao;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {
	
	T create(T entity);
	T update(T entity);
	T getById(Integer id);
	List<T> getAll();
	void delete(Integer id);
	
	Connection getConnection();
	
}
