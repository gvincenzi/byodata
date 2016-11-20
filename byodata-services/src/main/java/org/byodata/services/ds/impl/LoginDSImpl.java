package org.byodata.services.ds.impl;

import org.byodata.commons.enums.BYODataErrorEnum;
import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.model.dao.IUserDao;
import org.byodata.model.entity.User;
import org.byodata.services.ds.ILoginDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Implementation of service to login in the web application
 * @author Giuseppe Vincenzi
 *
 */
@Service
public class LoginDSImpl implements ILoginDS{
	@Autowired
	private IUserDao userDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User login(String username, String password) throws BYODataGenericException {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			throw new BYODataGenericException(BYODataErrorEnum.LOGIN_ERROR, "Username or password is null");
		}
		
		User user = userDao.getUserByUsername(username);
		if(user==null){
			throw new BYODataGenericException(BYODataErrorEnum.LOGIN_ERROR, "User does not exist");
		}
		
		return user;
	}

}
