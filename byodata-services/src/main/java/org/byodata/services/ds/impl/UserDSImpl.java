/**
 * 
 */
package org.byodata.services.ds.impl;

import java.util.List;

import org.byodata.commons.enums.BYODataErrorEnum;
import org.byodata.commons.exceptions.BYODataRequestException;
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
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(int userId) throws BYODataRequestException {
		if(userId<0){
			throw new BYODataRequestException(BYODataErrorEnum.INPUT_GET_USER_PARAMETER_ERROR,"The user ID must be greater than 0");
		}
		return userDao.getUserById(userId);
	}

}
