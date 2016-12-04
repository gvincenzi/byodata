package org.byodata.rest.api.controller;

import java.util.List;

import org.byodata.commons.api.View;
import org.byodata.commons.enums.BYODataErrorEnum;
import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.commons.exceptions.BYODataNoContentException;
import org.byodata.commons.exceptions.BYODataRequestException;
import org.byodata.model.entity.User;
import org.byodata.services.ds.IUserDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * UserController
 * 
 * @author Giuseppe Vincenzi
 *
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
	@Autowired
	IUserDS userService;

	@JsonView(View.User.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.getUsers();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);

	}

	@JsonView(View.UserWithRoles.class)
	@RequestMapping(value = "/roles/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsersWithRoles() {
		return listAllUsers();
	}

	@JsonView(View.User.class)
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByID(@PathVariable int userId) throws BYODataRequestException, BYODataNoContentException {
		User user = userService.getUserById(userId);
		if (user == null) {
			throw new BYODataNoContentException(BYODataErrorEnum.INPUT_GET_USER_NOT_EXISTS_ERROR, "The user does not exist");
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@JsonView(View.UserWithRoles.class)
	@RequestMapping(value = "/roles/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserWithRolesByID(@PathVariable int userId) throws BYODataRequestException, BYODataNoContentException {
		return getUserByID(userId);
	}

	@ExceptionHandler(BYODataGenericException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@JsonView(View.BYODataException.class)
	public BYODataGenericException handleException(BYODataGenericException e) {
		return e;
	}
	
	@ExceptionHandler(BYODataRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@JsonView(View.BYODataException.class)
	public BYODataRequestException handleException(BYODataRequestException e) {
		return e;
	}
	
	@ExceptionHandler(BYODataNoContentException.class)
	@ResponseStatus(value = HttpStatus.OK)
	@JsonView(View.BYODataException.class)
	public BYODataNoContentException handleException(BYODataNoContentException e) {
		return e;
	}
}
