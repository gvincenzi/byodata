package org.byodata.rest.api.controller;

import java.util.List;

import org.byodata.commons.api.View;
import org.byodata.commons.exceptions.BYODataGenericException;
import org.byodata.model.entity.User;
import org.byodata.services.ds.IUserDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		List<User> users;
		try {
			users = userService.getUsers();
			if (users.isEmpty()) {
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		} catch (BYODataGenericException e) {
			return new ResponseEntity<List<User>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@JsonView(View.UserWithRoles.class)
	@RequestMapping(value = "/roles/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsersWithRoles() {
		return listAllUsers();
	}
}
