/**
 * 
 */
package org.byodata.services.ds.impl;

import java.util.List;

import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.model.dao.IUserDao;
import org.byodata.model.entity.User;
import org.byodata.services.ds.IUserDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of service to manage User object
 * @author Giuseppe Vincenzi
 *
 */
@Service
public class UserDSImpl implements IUserDS {
	@Autowired
	private IUserDao userDao;

	@Override
	public List<User> getUsers() throws BYODataGenericException {
		return userDao.getAllUsers();
	}

}
