package org.byodata.services.ds.test;

import java.util.List;

import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.model.dao.IUserDao;
import org.byodata.model.entity.User;
import org.byodata.services.config.test.TestServicesConfig;
import org.byodata.services.ds.ILoginDS;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit Test of Service for login
 * 
 * @author Giuseppe Vincenzi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestServicesConfig.class)
@ActiveProfiles("test")
public class LoginDSTest {
	@Autowired
	private ILoginDS loginDS;

	@Autowired
	private IUserDao userDao;

	@Test(expected = BYODataGenericException.class)
	public void testLoginFailed1() throws BYODataGenericException {
		List<User> users = userDao.getAllUsers();
		Assert.assertNotNull(users);

		if (!users.isEmpty()) {
			User user = users.get(0);
			Assert.assertNotNull(user);
			loginDS.login(user.getUsername(), "");
		}
	}

	@Test(expected = BYODataGenericException.class)
	public void testLoginFailed2() throws BYODataGenericException {
		loginDS.login("", "");
	}

	@Test
	public void testLogin() throws BYODataGenericException {
		List<User> users = userDao.getAllUsers();
		Assert.assertNotNull(users);

		for (User user : users) {
			User loggedUser = loginDS.login(user.getUsername(), user.getPassword());
			Assert.assertNotNull(user);
			Assert.assertEquals(user.getUserId(), loggedUser.getUserId());
		}
	}

}
