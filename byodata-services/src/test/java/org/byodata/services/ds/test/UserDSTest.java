package org.byodata.services.ds.test;

import java.util.List;

import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.model.entity.User;
import org.byodata.services.config.test.TestServicesConfig;
import org.byodata.services.ds.IUserDS;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit Test of Service for User Service
 * 
 * @author Giuseppe Vincenzi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestServicesConfig.class)
@ActiveProfiles("test")
public class UserDSTest {
	@Autowired
	private IUserDS userDS;

	@Test
	public void testGetUsers() throws BYODataGenericException {
		List<User> users = userDS.getUsers();
		Assert.assertNotNull(users);
	}
}
