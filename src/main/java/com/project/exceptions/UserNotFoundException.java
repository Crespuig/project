package com.project.exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(int id) {
	    super("Could not find user " + id);
	  }
	}
