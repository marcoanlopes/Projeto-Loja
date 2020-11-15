package br.edu.up.dao;

import java.sql.Connection;
import java.util.List;

public interface DAO<T> {
	
	T save(T entidade);
	T updateDAO(T entidade);
	T findById(Integer id);
	List<T> list();
	void erase(Integer id);
//	Connection getConnection();
	
}
