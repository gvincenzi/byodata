package org.byodata.services.ds;

import java.util.List;

import org.byodata.commons.exceptions.BYODataGenericException;
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
	public List<User> getUsers() throws BYODataGenericException;
}
