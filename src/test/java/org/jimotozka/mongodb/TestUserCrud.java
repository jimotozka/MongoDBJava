package org.jimotozka.mongodb;

import org.jimotozka.mongodb.dao.UserDao;
import org.jimotozka.mongodb.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/mongo-config.xml",
		"/application-context.xml" })
public class TestUserCrud {

	@Autowired
	private UserDao userDao;

	@Test
	public void testSaveUser() {
		User user  = new User();
		user.setName("Dima");
		user.setSurname("Surname");
		user.setPassword("some_pass");
		user.setAge(20);
		user.setId(1l);
		
		userDao.save(user);
	}

}
