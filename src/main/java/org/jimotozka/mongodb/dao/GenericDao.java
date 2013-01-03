package org.jimotozka.mongodb.dao;

import java.util.List;

public interface GenericDao<T> {

	public void save(T entity);

	public void delete(T entity);

	public void delete(Long id);

	public T get(Long id);

	public List<T> getAll();
	
}
