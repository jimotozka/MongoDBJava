package org.jimotozka.mongodb.dao;

import java.util.List;

import org.jimotozka.mongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements GenericDao<User>{
	
	private static final String USERS_COLLECTION_NAME = "users";

	@Autowired
	private MongoOperations mongo;
	
	public void save(User entity) {
		mongo.save(entity, USERS_COLLECTION_NAME);
	}

	public void delete(User entity) {
		mongo.remove(new Query(Criteria.where("id").is(entity.getId())), User.class);
	}

	public void delete(Long id) {
		mongo.remove(new Query(Criteria.where("id").is(id)), User.class);
	}

	public User get(Long id) {
		return mongo.findOne(new Query(Criteria.where("id").is(id)), User.class, USERS_COLLECTION_NAME);
	}

	public List<User> getAll() {
		return mongo.findAll(User.class, USERS_COLLECTION_NAME);
	}

}
