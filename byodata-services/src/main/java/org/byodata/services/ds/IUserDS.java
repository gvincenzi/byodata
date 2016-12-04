package org.byodata.services.ds;

import java.util.List;

import org.byodata.commons.exceptions.BYODataRequestException;
import org.byodata.model.entity.User;

/**
 * Interface of service to manage User object
 * @author Giuseppe Vincenzi
 *
 */
public interface IUserDS {
	/**
	 * Method to get a list of all users
	 * @return List<User>
	 */
	public List<User> getUsers();
	
	/**
	 * Method to find an User by its ID
	 * @param userId User ID to find
	 * @return User
	 * @throws BYODataRequestException Error in parameter format
	 */
	public User getUserById(int userId) throws BYODataRequestException;
}
