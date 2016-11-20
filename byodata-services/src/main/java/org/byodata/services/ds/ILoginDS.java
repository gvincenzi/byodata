package org.byodata.services.ds;

import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.model.entity.User;

/**
 * Interface of service to login in the web application
 * @author Giuseppe Vincenzi
 *
 */
public interface ILoginDS {
	/**
	 * Method to verify the login of an user
	 * @param username String
	 * @param password String
	 * @return User
	 */
	public User login(String username, String password) throws BYODataGenericException;
}
